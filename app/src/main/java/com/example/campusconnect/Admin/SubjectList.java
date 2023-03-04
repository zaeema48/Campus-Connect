package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.campusconnect.Adapter.SubjectListAdapter;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class SubjectList extends AppCompatActivity {

    RecyclerView recyclerView;
    SubjectListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        recyclerView=findViewById(R.id.subjectListRV);

        ArrayList<SubjectModel> subjectList = new ArrayList<>();

        SubjectModel subject0 = new SubjectModel(1101, "JAVA");
        subjectList.add(subject0);

        SubjectModel subject1 = new SubjectModel(1102, "C++");
        subjectList.add(subject1);

        SubjectModel subject2 = new SubjectModel(1103, "C#");
        subjectList.add(subject2);

        SubjectModel subject3 = new SubjectModel(1104, "C Programming");
        subjectList.add(subject3);


        adapter = new SubjectListAdapter(SubjectList.this, subjectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectList.this));
        recyclerView.setAdapter(adapter);

    }
}