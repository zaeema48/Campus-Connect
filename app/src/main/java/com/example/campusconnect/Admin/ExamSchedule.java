package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class ExamSchedule extends AppCompatActivity {
    EditText batchId;
    AppCompatButton saveBtn;
    EditText s1, s2, s3, s4, s5, d1, d2, d3, d4, d5, t1, t2, t3, t4, t5, r1, r2, r3, r4, r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_schedule);

        fetchView();

        ExamScheduleModel examScheduleModel= new ExamScheduleModel();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batch_id = batchId.getText().toString();
                if(!batch_id.isEmpty()){

                    ArrayList<ExamScheduleModel> examSchedule= new ArrayList<>();

                    examSchedule.get(0).setSubject(s1.getText().toString());
                    examSchedule.get(0).setDate(d1.getText().toString());
                    examSchedule.get(0).setTime(t1.getText().toString());
                    examSchedule.get(0).setRoomAllocated(r1.getText().toString());

                    examSchedule.get(1).setSubject(s2.getText().toString());
                    examSchedule.get(1).setDate(d2.getText().toString());
                    examSchedule.get(1).setTime(t2.getText().toString());
                    examSchedule.get(1).setRoomAllocated(r2.getText().toString());

                    examSchedule.get(2).setSubject(s3.getText().toString());
                    examSchedule.get(2).setDate(d3.getText().toString());
                    examSchedule.get(2).setTime(t3.getText().toString());
                    examSchedule.get(2).setRoomAllocated(r3.getText().toString());

                    examSchedule.get(3).setSubject(s4.getText().toString());
                    examSchedule.get(3).setDate(d4.getText().toString());
                    examSchedule.get(3).setTime(t4.getText().toString());
                    examSchedule.get(3).setRoomAllocated(r4.getText().toString());

                    examSchedule.get(4).setSubject(s5.getText().toString());
                    examSchedule.get(4).setDate(d5.getText().toString());
                    examSchedule.get(4).setTime(t5.getText().toString());
                    examSchedule.get(4).setRoomAllocated(r5.getText().toString());



                }

                else
                    Toast.makeText(ExamSchedule.this, "PLease fill the Required Details!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void fetchView(){
        batchId=findViewById(R.id.edit);
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