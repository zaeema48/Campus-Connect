package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Adapter.SearchExamScheduleAdapter;
import com.example.campusconnect.Adapter.SearchTeacherAdapter;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class ViewExamSchedule extends AppCompatActivity {
    RecyclerView searchExam;
    SearchExamScheduleAdapter adapter;
    AppCompatButton searchBtn;
    EditText searchText;
    String search_exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam_schedule);

        searchExam=findViewById(R.id.searchExam);
        searchBtn=findViewById(R.id.searchExam);
        searchText=findViewById(R.id.searchText);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_exam=searchText.getText().toString();
                if(!search_exam.isEmpty()){
                    //REST API CALLING (retrofit work)
                }
                else{
                    Toast.makeText(ViewExamSchedule.this, "Enter Batch id !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<ExamScheduleModel> examSchedule= new ArrayList<>();
        //TESTING DATA SET
        ExamScheduleModel examScheduleModel=new ExamScheduleModel(1, "English", "12/03/23", "10:00AM", "201");
        ExamScheduleModel examScheduleModel2=new ExamScheduleModel(2, "Hindi", "15/03/23", "10:00AM", "204");
        ExamScheduleModel examScheduleModel3=new ExamScheduleModel(3, "Maths", "16/03/23", "10:00AM", "200");
        examSchedule.add(examScheduleModel);
        examSchedule.add(examScheduleModel2);
        examSchedule.add(examScheduleModel3);

        adapter=new SearchExamScheduleAdapter(ViewExamSchedule.this,examSchedule);
        searchExam.setLayoutManager(new LinearLayoutManager(ViewExamSchedule.this));
        searchExam.setAdapter(adapter);
    }
}