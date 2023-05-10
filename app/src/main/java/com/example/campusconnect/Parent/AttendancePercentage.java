package com.example.campusconnect.Parent;

import static com.example.campusconnect.ParentLogin.publicParent;

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
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendancePercentage extends AppCompatActivity {

    TextView sub1, sub2, sub3, sub4, sub5, s1, s2, s3, s4, s5;
    AutoCompleteTextView sem;
    AppCompatButton search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_percentage2);

        sem=findViewById(R.id.semester);
        search=findViewById(R.id.searchButton);
        sub1=findViewById(R.id.sub1);
        sub2=findViewById(R.id.sub2);
        sub3=findViewById(R.id.sub3);
        sub4=findViewById(R.id.sub4);
        sub5=findViewById(R.id.sub5);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        s4=findViewById(R.id.s4);
        s5=findViewById(R.id.s5);

        String [] semesters= {"1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
        ArrayAdapter<String> dropdownAdapter =new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, semesters);
        sem.setThreshold(1);
        sem.setAdapter(dropdownAdapter);

        ProgressDialog progressDialog = new ProgressDialog(AttendancePercentage.this);
        progressDialog.setTitle("Fetching Attendance...");
        List<StudentProgressModel> studentProgress= new ArrayList<>();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String semester=sem.getText().toString();
                if(!semester.isEmpty()) {
                    progressDialog.show();
                    ParentAPI.getParentApiInterface().semesterProgress(publicParent.getStudentId(), semester).enqueue(new Callback<List<StudentProgressModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentProgressModel>> call, Response<List<StudentProgressModel>> response) {
                            studentProgress.clear();
                            studentProgress.addAll(response.body());
                            if(studentProgress.size()!=0)
                                subjectPercentage(studentProgress);
                            else
                                Toast.makeText(AttendancePercentage.this, "This Semester has not Started Yet!!", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<StudentProgressModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(AttendancePercentage.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });


    }

    public void subjectPercentage(List<StudentProgressModel> studentProgress){
        s1.setText(studentProgress.get(0).getProgressId().substring(4));
        sub1.setText(studentProgress.get(0).getAttendancePercentage()+"%");
        s2.setText(studentProgress.get(1).getProgressId().substring(4));
        sub2.setText(studentProgress.get(1).getAttendancePercentage()+"%");
        s3.setText(studentProgress.get(2).getProgressId().substring(4));
        sub3.setText(studentProgress.get(2).getAttendancePercentage()+"%");
        s4.setText(studentProgress.get(3).getProgressId().substring(4));
        sub4.setText(studentProgress.get(3).getAttendancePercentage()+"%");
        s5.setText(studentProgress.get(4).getProgressId().substring(4));
        sub5.setText(studentProgress.get(4).getAttendancePercentage()+"%");
    }

}