package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.campusconnect.Adapter.TeacherListAdapter;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class TeacherList extends AppCompatActivity {

    RecyclerView recyclerView;
    TeacherListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        recyclerView=findViewById(R.id.teacherListRV);
        //TESTING DATA SET
        ArrayList<TeacherModel> teachers = new ArrayList<>();
        teachers.get(0).setTeacherName("Zeeshan");
        teachers.get(0).setTeacherId(321);
        teachers.get(0).getSubject().setSubjectName("Java");
        teachers.get(0).setSalary("90k");
        teachers.get(1).setTeacherName("Zaeema");
        teachers.get(1).setTeacherId(322);
        teachers.get(1).getSubject().setSubjectName("C++");
        teachers.get(1).setSalary("90k");

        adapter=new TeacherListAdapter(TeacherList.this,teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(TeacherList.this));
        recyclerView.setAdapter(adapter);

    }
}