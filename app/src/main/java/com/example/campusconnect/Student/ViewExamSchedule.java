package com.example.campusconnect.Student;

import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Adapter.SearchExamScheduleAdapter;
import com.example.campusconnect.Admin.ExamSchedule;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewExamSchedule extends AppCompatActivity {
    RecyclerView examScheduleRV;
    SearchExamScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam_schedule);

        examScheduleRV=findViewById(R.id.examScheduleRV);
        ProgressDialog progressDialog= new ProgressDialog(ViewExamSchedule.this);
        progressDialog.setTitle("Fetching Exam Schedules..");
        progressDialog.show();

        List<ExamScheduleModel> examSchedule= new ArrayList<>();
        adapter=new SearchExamScheduleAdapter(ViewExamSchedule.this,examSchedule);
        examScheduleRV.setLayoutManager(new LinearLayoutManager(ViewExamSchedule.this));
        examScheduleRV.setAdapter(adapter);

        StudentAPI.getStudentApiInterface().fetchExamSchedule(publicStudent.getStudentId()).enqueue(new Callback<List<ExamScheduleModel>>() {
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
                Toast.makeText(ViewExamSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}