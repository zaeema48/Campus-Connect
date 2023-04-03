package com.example.campusconnect.Teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    AppCompatButton submit;
    RecyclerView recyclerView;

    String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        batch=findViewById(R.id.batch);
        dateBtn=findViewById(R.id.dateBtn);
        day=findViewById(R.id.date);
        submit=findViewById(R.id.submit_button);
        recyclerView=findViewById(R.id.rv);

        List<StudentModel> studentList= new ArrayList<>();
        MarkAttendanceAdapter adapter= new MarkAttendanceAdapter(MarkAttendance.this, studentList, date);
        recyclerView.setLayoutManager(new LinearLayoutManager(MarkAttendance.this));
        recyclerView.setAdapter(adapter);

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
                    TeacherApi.getTeacherApiInterface().BatchStudents(batchId).enqueue(new Callback<List<StudentModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                            studentList.clear();
                            studentList.addAll(response.body());
                            adapter.notifyDataSetChanged();
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

    }
}