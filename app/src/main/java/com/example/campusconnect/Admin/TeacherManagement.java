package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.campusconnect.R;

public class TeacherManagement extends AppCompatActivity {

    TextView addTeacher, removeTeacher, searchTeacher, teacherList, updateTeacher, subjectList, updateTeacherSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_management);

        addTeacher = findViewById(R.id.addTeacher);
        removeTeacher = findViewById(R.id.removeTeacher);
        searchTeacher = findViewById(R.id.searchTeacher);
        teacherList = findViewById(R.id.teacherList);
        updateTeacher = findViewById(R.id.updateTeacher);
        updateTeacherSchedule= findViewById(R.id.updateTeacherSchedule);
        subjectList = findViewById(R.id.subjectList);

        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, AddTeacher.class);
                startActivity(intent);
            }
        });

        removeTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, RemoveTeacher.class);
                startActivity(intent);
            }
        });

        searchTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, SearchTeacher.class);
                startActivity(intent);
            }
        });

        teacherList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, TeacherList.class);
                startActivity(intent);
            }
        });

        updateTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, UpdateTeacher.class);
                startActivity(intent);
            }
        });

        subjectList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, SubjectList.class);
                startActivity(intent);
            }
        });

        updateTeacherSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TeacherManagement.this, UpdateTeacherSchedule.class);
                startActivity(intent);
            }
        });
    }
}