package com.example.campusconnect.Teacher;


import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Adapter.StudentAttendanceAdapter;
import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewStudentAttendance extends AppCompatActivity {

    EditText studentId;
    Button submit;
    RecyclerView recyclerView;
    int sId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_attendance);

        studentId=findViewById(R.id.studentId);
        submit=findViewById(R.id.submit);
        recyclerView=findViewById(R.id.viewStudentRV);

        int subjectId=publicTeacher.getSubject().getSubjectId();
        List<AttendanceModel> attendances= new ArrayList<>();
        StudentAttendanceAdapter adapter= new StudentAttendanceAdapter(ViewStudentAttendance.this,attendances);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewStudentAttendance.this));
        recyclerView.setAdapter(adapter);

        ProgressDialog progressDialog= new ProgressDialog(ViewStudentAttendance.this);
        progressDialog.setTitle("Fetching Student Attendance...");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sId=Integer.parseInt(studentId.getText().toString());
                TeacherApi.getTeacherApiInterface().studentAttendance(sId,subjectId).enqueue(new Callback<List<AttendanceModel>>() {
                    @Override
                    public void onResponse(Call<List<AttendanceModel>> call, Response<List<AttendanceModel>> response) {
                        progressDialog.show();
                        attendances.clear();
                        attendances.addAll(response.body());
                        adapter.setsID(sId);
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<List<AttendanceModel>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(ViewStudentAttendance.this, "An Error Has Occurred..", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}