package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.AdminPage;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddExamSchedule extends AppCompatActivity {
    EditText batchId;
    AppCompatButton saveBtn;
    EditText s1, s2, s3, s4, s5, d1, d2, d3, d4, d5, t1, t2, t3, t4, t5, r1, r2, r3, r4, r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam_schedule);

        fetchView();
        ProgressDialog progressDialog = new ProgressDialog(AddExamSchedule.this);
        progressDialog.setTitle("Adding Exam Schedule...");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batch_id = batchId.getText().toString();
                if(!batch_id.isEmpty()){
                    progressDialog.show();
                    ArrayList<ExamScheduleModel> examSchedule= new ArrayList<>();
                    ExamScheduleModel schedule1= new ExamScheduleModel();
                    schedule1.setDate(d1.getText().toString());
                    schedule1.setSubject(s1.getText().toString());
                    schedule1.setTime(t1.getText().toString());
                    schedule1.setRoomAllocated(r1.getText().toString());
                    examSchedule.add(schedule1);

                    ExamScheduleModel schedule2= new ExamScheduleModel();
                    schedule2.setDate(d2.getText().toString());
                    schedule2.setSubject(s2.getText().toString());
                    schedule2.setTime(t2.getText().toString());
                    schedule2.setRoomAllocated(r2.getText().toString());
                    examSchedule.add(schedule2);

                    ExamScheduleModel schedule3= new ExamScheduleModel();
                    schedule3.setDate(d3.getText().toString());
                    schedule3.setSubject(s3.getText().toString());
                    schedule3.setTime(t3.getText().toString());
                    schedule3.setRoomAllocated(r3.getText().toString());
                    examSchedule.add(schedule3);

                    ExamScheduleModel schedule4= new ExamScheduleModel();
                    schedule4.setDate(d4.getText().toString());
                    schedule4.setSubject(s4.getText().toString());
                    schedule4.setTime(t4.getText().toString());
                    schedule4.setRoomAllocated(r4.getText().toString());
                    examSchedule.add(schedule4);

                    ExamScheduleModel schedule5= new ExamScheduleModel();
                    schedule5.setDate(d5.getText().toString());
                    schedule5.setSubject(s5.getText().toString());
                    schedule5.setTime(t5.getText().toString());
                    schedule5.setRoomAllocated(r5.getText().toString());
                    examSchedule.add(schedule5);

                    //REST API WORK FOR SENDING THE ARRAYLIST
                    ApiUtilities.getAdminApiInterface().addExamSchedule(batch_id,examSchedule).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(AddExamSchedule.this, "Exam Schedule Added SuccessFully.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddExamSchedule.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(AddExamSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                else
                    Toast.makeText(AddExamSchedule.this, "Please fill the Required Details!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void fetchView(){
        batchId=findViewById(R.id.batchId);
        saveBtn=findViewById(R.id.ExamSave);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        s4=findViewById(R.id.s4);
        s5=findViewById(R.id.s5);
        d1=findViewById(R.id.d1);
        d2=findViewById(R.id.d2);
        d3=findViewById(R.id.d3);
        d4=findViewById(R.id.d4);
        d5=findViewById(R.id.d5);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);

    }
}