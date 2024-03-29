package com.example.campusconnect.Teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Adapter.MarkAttendanceAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarkAttendance extends AppCompatActivity {
    EditText batch;
    TextView day;
    MaterialButton dateBtn;
    AppCompatButton submit, upload;
    RecyclerView recyclerView;
    CheckBox selectAll;
    String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        batch=findViewById(R.id.batch);
        dateBtn=findViewById(R.id.dateBtn);
        day=findViewById(R.id.date);
        submit=findViewById(R.id.submit_button);
        upload=findViewById(R.id.upload);
        selectAll=findViewById(R.id.checkBox);
        recyclerView=findViewById(R.id.rv);

        List<StudentModel> studentList= new ArrayList<>();
        MarkAttendanceAdapter adapter= new MarkAttendanceAdapter(MarkAttendance.this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MarkAttendance.this));
        recyclerView.setAdapter(adapter);

        ProgressDialog progressDialog= new ProgressDialog(MarkAttendance.this);
        progressDialog.setTitle("Fetching Students...");

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker datePicker= MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Date").build();

                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        date=""+datePicker.getHeaderText();
                        day.setText(date);
                    }
                });

                datePicker.show(getSupportFragmentManager(),"Date");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batchId;
                batchId=batch.getText().toString();

                if(!batchId.isEmpty() && !date.isEmpty()){
                    progressDialog.show();
                    TeacherApi.getTeacherApiInterface().BatchStudents(batchId).enqueue(new Callback<List<StudentModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                            studentList.clear();
                            if(response.isSuccessful()) {
                                studentList.addAll(response.body());
                                adapter.setBatchId(batchId);
                                adapter.setDate(date);
                                adapter.notifyDataSetChanged();
                                progressDialog.dismiss();
                            }
                            else{
                                adapter.notifyDataSetChanged();
                                progressDialog.dismiss();
                                Toast.makeText(MarkAttendance.this, "Enter the right Batch Id!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                            Toast.makeText(MarkAttendance.this, "Error!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(MarkAttendance.this, "Please Select Batch and Date!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.uploadAttendance();
            }
        });

        selectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    adapter.allPresent();
                else
                    adapter.allAbsent();
            }
        });

    }
}