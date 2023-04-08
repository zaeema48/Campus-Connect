package com.example.campusconnect.Student;

import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewMarks extends AppCompatActivity {
TextView subject1, subject2, subject3, subject4, subject5, marks1, marks2, marks3, marks4, marks5, total ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        subject1=findViewById(R.id.sub1);
        subject2=findViewById(R.id.sub2);
        subject3=findViewById(R.id.sub3);
        subject4=findViewById(R.id.sub4);
        subject5=findViewById(R.id.sub5);
        marks1=findViewById(R.id.marks1);
        marks2=findViewById(R.id.marks2);
        marks3=findViewById(R.id.marks3);
        marks4=findViewById(R.id.marks4);
        marks5=findViewById(R.id.marks5);

        List<StudentProgressModel> marksList= new ArrayList<>();

        StudentAPI.getStudentApiInterface().viewMarks(publicStudent.getStudentId()).enqueue(new Callback<List<StudentProgressModel>>() {
            @Override
            public void onResponse(Call<List<StudentProgressModel>> call, Response<List<StudentProgressModel>> response) {
                marksList.clear();
                marksList.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<StudentProgressModel>> call, Throwable t) {

            }
        });

    }
}