package com.example.campusconnect.Parent;

import static com.example.campusconnect.ParentLogin.publicParent;
import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.ParentAPI;
import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;
import com.example.campusconnect.Student.ViewMarks;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildSubjectMarks extends AppCompatActivity {

    TextView subject1, subject2, subject3, subject4, subject5, marks1, marks2, marks3, marks4, marks5, total ;
    AutoCompleteTextView sem;
    AppCompatButton search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_subject_marks);
        sem=findViewById(R.id.semester);
        search=findViewById(R.id.searchButton);
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

        String [] semesters= {"1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
        ArrayAdapter<String> dropdownAdapter =new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, semesters);
        sem.setThreshold(1);
        sem.setAdapter(dropdownAdapter);

        ProgressDialog progressDialog= new ProgressDialog(ChildSubjectMarks.this);
        progressDialog.setTitle("Fetching Results...");

        List<StudentProgressModel> marksList= new ArrayList<>();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String semester=sem.getText().toString();
                if(!semester.isEmpty()){
                    progressDialog.show();
                    ParentAPI.getParentApiInterface().semesterProgress(publicParent.getStudentId(), semester).enqueue(new Callback<List<StudentProgressModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentProgressModel>> call, Response<List<StudentProgressModel>> response) {
                            marksList.clear();
                            marksList.addAll(response.body());
                            if(marksList.size()!=0) {
                                setSubjectAndMarksView(marksList);
                            }
                            else
                                Toast.makeText(ChildSubjectMarks.this, "Result of this Semester has not yet Uploaded!!", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<StudentProgressModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(ChildSubjectMarks.this, "ERROR!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                    Toast.makeText(ChildSubjectMarks.this, "Select Semester!!", Toast.LENGTH_SHORT).show();


            }
        });

    }
    public void setSubjectAndMarksView( List<StudentProgressModel> list){
        subject1.setText(list.get(0).getProgressId().substring(4));
        marks1.setText(""+ list.get(0).getMarks());

        subject2.setText(list.get(1).getProgressId().substring(4));
        marks2.setText(""+ list.get(1).getMarks());

        subject3.setText(list.get(2).getProgressId().substring(4));
        marks3.setText(""+ list.get(2).getMarks());

        subject4.setText(list.get(3).getProgressId().substring(4));
        marks4.setText(""+ list.get(3).getMarks());

        subject5.setText(list.get(4).getProgressId().substring(4));
        marks5.setText(""+ list.get(4).getMarks());

        int marks=list.get(0).getMarks()+list.get(1).getMarks()+list.get(2).getMarks()+list.get(3).getMarks()+list.get(4).getMarks();
        float percentage=marks/5;
        total.setText(""+ percentage);
    }
}