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
import com.example.campusconnect.Adapter.SearchTeacherAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class SearchTeacher extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchTeacherAdapter adapter;
    EditText name;
    AppCompatButton searchBtn;

    String teacherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_teacher);
        recyclerView=findViewById(R.id.searchTeacherRV);
        name=findViewById(R.id.teacher_name);
        searchBtn=findViewById(R.id.submitBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherName=name.getText().toString();
                if(!teacherName.isEmpty()){
                    //REST API CALLING (retrofit work)
                }
                else{
                    Toast.makeText(SearchTeacher.this, "No Name has been entered!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<TeacherModel> teachers= new ArrayList<>();
        //TESTING DATA SET
        SubjectModel subject1=new SubjectModel(12,"Java");
        TeacherModel teacher1=new TeacherModel(123,"abcde","Zeeshan", "jhbdkjsd@hjd","85k",subject1);
        teachers.add(teacher1);

        adapter=new SearchTeacherAdapter(SearchTeacher.this,teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchTeacher.this));
        recyclerView.setAdapter(adapter);

    }
}