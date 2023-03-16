package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.SearchExamScheduleAdapter;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExamSchedule extends AppCompatActivity {
    RecyclerView searchExam;
    SearchExamScheduleAdapter adapter;
    AppCompatButton searchBtn;
    EditText searchText;
    String batchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_schedule);

        searchExam=findViewById(R.id.searchExamRV);
        searchBtn=findViewById(R.id.searchExam);
        searchText=findViewById(R.id.searchText);
        ProgressDialog progressDialog= new ProgressDialog(ExamSchedule.this);
        progressDialog.setTitle("Fetching Exam Schedules..");

        List<ExamScheduleModel> examSchedule= new ArrayList<>();
        adapter=new SearchExamScheduleAdapter(ExamSchedule.this,examSchedule);
        searchExam.setLayoutManager(new LinearLayoutManager(ExamSchedule.this));
        searchExam.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batchId=searchText.getText().toString();
                if(!batchId.isEmpty()){
                    progressDialog.show();
                    ApiUtilities.getAdminApiInterface().getExamSchedule(batchId).enqueue(new Callback<List<ExamScheduleModel>>() {
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
                            Toast.makeText(ExamSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ExamSchedule.this, "Enter Batch ID !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}