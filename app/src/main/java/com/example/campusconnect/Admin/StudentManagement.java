package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.campusconnect.R;

public class StudentManagement extends AppCompatActivity {
    TextView addStudent, removeStudent, searchStudent, updateFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);

        addStudent = findViewById(R.id.addStudent);
        removeStudent = findViewById(R.id.removeStudent);
        searchStudent = findViewById(R.id.searchStudent);
        updateFees = findViewById(R.id.updateFee);


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (StudentManagement.this, AddStudent.class);
                startActivity(intent);
            }
        });

        removeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (StudentManagement.this, RemoveStudent.class);
                startActivity(intent);
            }
        });

        searchStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (StudentManagement.this, SearchStudent.class);
                startActivity(intent);
            }
        });



        updateFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (StudentManagement.this, UpdateFees.class);
                startActivity(intent);
            }
        });

    }
}