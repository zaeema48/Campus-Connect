package com.example.campusconnect.Student;

import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Adapter.StudentAttendanceAdapter;
import com.example.campusconnect.Adapter.SubjectAttendanceAdapter;
import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAttendance extends AppCompatActivity {
    EditText subjectId;
    Button submit;
    RecyclerView recyclerView;
    int sId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        subjectId=findViewById(R.id.subjectId);
        submit=findViewById(R.id.submit);
        recyclerView=findViewById(R.id.viewStudentRV);

        ProgressDialog progressDialog= new ProgressDialog(ViewAttendance.this);
        progressDialog.setTitle("Fetching Attendance...");

        List<AttendanceModel> attendanceList= new ArrayList<>();
        SubjectAttendanceAdapter adapter= new SubjectAttendanceAdapter(ViewAttendance.this, attendanceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewAttendance.this));
        recyclerView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject_id=subjectId.getText().toString();
                if(!subject_id.isEmpty()){
                    progressDialog.show();
                    StudentAPI.getStudentApiInterface().viewSubjectAttendance(publicStudent.getStudentId(), Integer.parseInt(subject_id)).enqueue(new Callback<List<AttendanceModel>>() {
                        @Override
                        public void onResponse(Call<List<AttendanceModel>> call, Response<List<AttendanceModel>> response) {
                            attendanceList.clear();
                            if(response.isSuccessful()) {
                                attendanceList.addAll(response.body());
                                adapter.setSubject_id(Integer.parseInt(subject_id));
                                adapter.notifyDataSetChanged();
                                progressDialog.dismiss();
                            }
                            else{
                                adapter.notifyDataSetChanged();
                                progressDialog.dismiss();
                                Toast.makeText(ViewAttendance.this, "There is no attendance record for this subject!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<AttendanceModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(ViewAttendance.this, "ERROR!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ViewAttendance.this, "Enter Subject Id!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}