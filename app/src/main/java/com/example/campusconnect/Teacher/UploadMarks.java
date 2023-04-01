package com.example.campusconnect.Teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Adapter.UploadMarksAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;
import com.example.campusconnect.TeacherPage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadMarks extends AppCompatActivity {
EditText batch_id;
AppCompatButton submit_button, save_button;
RecyclerView recyclerView;
UploadMarksAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_marks);

        batch_id=findViewById(R.id.batch);
        submit_button=findViewById(R.id.submit_button);
        save_button=findViewById(R.id.save_button);
        recyclerView=findViewById(R.id.uploadMarksRV);

        ProgressDialog progressDialog= new ProgressDialog(UploadMarks.this);
        progressDialog.setTitle("Fetching Student List...");

        List<StudentModel> studentList= new ArrayList<>();
        adapter= new UploadMarksAdapter(UploadMarks.this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(UploadMarks.this));
        recyclerView.setAdapter(adapter);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batchId;
                batchId=batch_id.getText().toString();
                if(!batchId.isEmpty()){
                    progressDialog.show();
                    TeacherApi.getTeacherApiInterface().BatchStudents(batchId).enqueue(new Callback<List<StudentModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                            studentList.clear();
                            studentList.addAll(response.body());
                            adapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UploadMarks.this, "An Error has occurred", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        ProgressDialog progressDialog1= new ProgressDialog(UploadMarks.this);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.saveStudentList();
                Toast.makeText(UploadMarks.this, "Marks uploaded successfully", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(UploadMarks.this, TeacherPage.class);
                startActivity(intent);
            }
        });

    }
}