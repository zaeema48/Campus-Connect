package com.example.campusconnect.Student;

import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
        total=findViewById(R.id.totalPercentage);

        ProgressDialog progressDialog= new ProgressDialog(ViewMarks.this);
        progressDialog.setTitle("Fetching Marks...");

        List<StudentProgressModel> marksList= new ArrayList<>();

        StudentAPI.getStudentApiInterface().viewMarks(publicStudent.getStudentId()).enqueue(new Callback<List<StudentProgressModel>>() {
            @Override
            public void onResponse(Call<List<StudentProgressModel>> call, Response<List<StudentProgressModel>> response) {
                progressDialog.show();
                marksList.clear();
                marksList.addAll(response.body());
                setSubjectAndMarksView(marksList);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<StudentProgressModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ViewMarks.this, "ERROR!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void setSubjectAndMarksView( List<StudentProgressModel> list){
        subject1.setText(list.get(0).getProgressId());
        marks1.setText(""+ list.get(0).getMarks());

        subject2.setText(list.get(1).getProgressId());
        marks2.setText(""+ list.get(1).getMarks());

        subject3.setText(list.get(2).getProgressId());
        marks3.setText(""+ list.get(2).getMarks());

        subject4.setText(list.get(3).getProgressId());
        marks4.setText(""+ list.get(3).getMarks());

        subject5.setText(list.get(4).getProgressId());
        marks5.setText(""+ list.get(4).getMarks());

        int marks=list.get(0).getMarks()+list.get(1).getMarks()+list.get(2).getMarks()+list.get(3).getMarks()+list.get(4).getMarks();
        float percentage=marks/5;
        total.setText(""+ percentage);
    }
}