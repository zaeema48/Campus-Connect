package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Adapter.SearchStudentAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class SearchStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchStudentAdapter adapter;
    EditText name;
    AppCompatButton submitBtn;

    String studentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        recyclerView= findViewById(R.id.searchStudentRV);
        name=findViewById(R.id.student_name);
        submitBtn=findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentName=name.getText().toString();
                if(!studentName.isEmpty()){
                    //REST API CALLING (retrofit work)
                }
                else{
                    Toast.makeText(SearchStudent.this, "No Student Name has been entered!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<StudentModel> students= new ArrayList<>();
        //TESTING DATA SET
        StudentModel student1= new StudentModel(12,"abc123","Zaeema", "xyz123456@jjd", "acb123456@iik", true);
        StudentModel student2= new StudentModel(16,"abc123","Zeeshan", "xyz123456@jjd", "acb123456@iik", true);
        students.add(student1);
        students.add(student2);

        adapter=new SearchStudentAdapter(SearchStudent.this,students);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchStudent.this));
        recyclerView.setAdapter(adapter);
    }
}