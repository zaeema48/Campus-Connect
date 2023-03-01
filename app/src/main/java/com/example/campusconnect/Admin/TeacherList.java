package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.campusconnect.Adapter.TeacherListAdapter;
import com.example.campusconnect.Models.SubjectModel;
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

        ArrayList<TeacherModel> teachers = new ArrayList<>();
        //TESTING DATA SET
        TeacherModel teacher1=new TeacherModel();
        teacher1.setTeacherId(872);
        teacher1.setTeacherName("zeeshan");
        teacher1.setSalary("90k");
        SubjectModel subject= new SubjectModel(21,"JAVA");
        teacher1.setSubject(subject);
        teachers.add(teacher1);
        TeacherModel teacher2=new TeacherModel();
        teacher2.setTeacherId(874);
        teacher2.setTeacherName("zaeema");
        teacher2.setSalary("90k");
        SubjectModel subject2= new SubjectModel(21,"C++");
        teacher2.setSubject(subject2);
        teachers.add(teacher2);


        adapter=new TeacherListAdapter(TeacherList.this,teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(TeacherList.this));
        recyclerView.setAdapter(adapter);

    }
}