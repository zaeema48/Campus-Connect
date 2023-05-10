package com.example.campusconnect.Parent;

import static com.example.campusconnect.ParentLogin.publicParent;
import static com.example.campusconnect.StudentLogin.publicStudent;
import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.campusconnect.API.ParentAPI;
import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Adapter.SearchExamScheduleAdapter;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;
import com.example.campusconnect.Student.ViewExamSchedule;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildExamSchedule extends AppCompatActivity {

    RecyclerView examScheduleRV;
    SearchExamScheduleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_exam_schedule);

        examScheduleRV=findViewById(R.id.examScheduleRV);
        ProgressDialog progressDialog= new ProgressDialog(ChildExamSchedule.this);
        progressDialog.setTitle("Fetching Exam Schedules..");
        progressDialog.show();

        List<ExamScheduleModel> examSchedule= new ArrayList<>();
        adapter=new SearchExamScheduleAdapter(ChildExamSchedule.this,examSchedule);
        examScheduleRV.setLayoutManager(new LinearLayoutManager(ChildExamSchedule.this));
        examScheduleRV.setAdapter(adapter);

        ParentAPI.getParentApiInterface().fetchExamSchedule(publicParent.getStudentId()).enqueue(new Callback<List<ExamScheduleModel>>() {
            @Override
            public void onResponse(Call<List<ExamScheduleModel>> call, Response<List<ExamScheduleModel>> response) {
                examSchedule.clear();
                examSchedule.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ExamScheduleModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ChildExamSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}