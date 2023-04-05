package com.example.campusconnect.Teacher;


import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Models.TeacherScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewSchedule extends AppCompatActivity {
    TextView m1,  m2, m3, m4, m5, t1, t2, t3, t4, t5, w1, w2, w3, w4, w5, th1, th2, th3, th4, th5, f1, f2, f3, f4, f5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);
        fetchView();
        ProgressDialog progressDialog= new ProgressDialog(ViewSchedule.this);
        progressDialog.setTitle("Getting Schedule...");
        progressDialog.show();

        List<TeacherScheduleModel> schedules=new ArrayList<>();
        TeacherApi.getTeacherApiInterface().scheduleModel(publicTeacher.getTeacherId()).enqueue(new Callback<List<TeacherScheduleModel>>() {
            @Override
            public void onResponse(Call<List<TeacherScheduleModel>> call, Response<List<TeacherScheduleModel>> response) {
                schedules.addAll(response.body());
                setView(schedules);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<TeacherScheduleModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ViewSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setView(List<TeacherScheduleModel> schedules){
//        SETTING TABLE VIEW
        m1.setText(schedules.get(0).getSlot1());
        m2.setText(schedules.get(0).getSlot2());
        m3.setText(schedules.get(0).getSlot3());
        m4.setText(schedules.get(0).getSlot4());
        m5.setText(schedules.get(0).getSlot5());

        t1.setText(schedules.get(1).getSlot1());
        t2.setText(schedules.get(1).getSlot2());
        t3.setText(schedules.get(1).getSlot3());
        t4.setText(schedules.get(1).getSlot4());
        t5.setText(schedules.get(1).getSlot5());

        w1.setText(schedules.get(2).getSlot1());
        w2.setText(schedules.get(2).getSlot2());
        w3.setText(schedules.get(2).getSlot3());
        w4.setText(schedules.get(2).getSlot4());
        w5.setText(schedules.get(2).getSlot5());

        th1.setText(schedules.get(3).getSlot1());
        th2.setText(schedules.get(3).getSlot2());
        th3.setText(schedules.get(3).getSlot3());
        th4.setText(schedules.get(3).getSlot4());
        th5.setText(schedules.get(3).getSlot5());

        f1.setText(schedules.get(4).getSlot1());
        f2.setText(schedules.get(4).getSlot2());
        f3.setText(schedules.get(4).getSlot3());
        f4.setText(schedules.get(4).getSlot4());
        f5.setText(schedules.get(4).getSlot5());
    }

    public void fetchView(){
        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        w1=findViewById(R.id.w1);
        w2=findViewById(R.id.w2);
        w3=findViewById(R.id.w3);
        w4=findViewById(R.id.w4);
        w5=findViewById(R.id.w5);
        th1=findViewById(R.id.th1);
        th2=findViewById(R.id.th2);
        th3=findViewById(R.id.th3);
        th4=findViewById(R.id.th4);
        th5=findViewById(R.id.th5);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
    }
}