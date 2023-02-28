package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.Models.TeacherScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class AddTeacher extends AppCompatActivity {

    EditText teacherName, salary, subject;
    EditText m1,  m2, m3, m4, m5, t1, t2, t3, t4, t5, w1, w2, w3, w4, w5, th1, th2, th3, th4, th5, f1, f2, f3, f4, f5;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        fetchView();

        TeacherModel teacher = new TeacherModel();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tname = teacherName.getText().toString();
                String tsalary= salary.getText().toString();
                String tsubject = subject.getText().toString();

                if(tname != null && tsalary != null && tsubject!=null){
                    teacher.setTeacherName(tname);
                    teacher.setSalary(tsalary);
                    SubjectModel subject = new SubjectModel();
                    subject.setSubjectName(tsubject);
                    teacher.setSubject(subject);

                    List<TeacherScheduleModel> schedules = new ArrayList<>();
                    schedules.get(0).setDay("Monday");
                    schedules.get(0).setSlot1("B.Tech CSE");
                    schedules.get(0).setSlot3("B.Tech ESE");

                    schedules.get(1).setDay("Tuesday");
                    schedules.get(1).setSlot2("B.Tech CSE");
                    schedules.get(1).setSlot4("B.Tech ESE");

                    schedules.get(2).setDay("Wednesday");
                    schedules.get(2).setSlot1("B.Tech CSE");
                    schedules.get(2).setSlot4("B.Tech ESE");

                    schedules.get(3).setDay("Thursday");
                    schedules.get(3).setSlot3("B.Tech CSE");
                    schedules.get(3).setSlot5("B.Tech ESE");

                    schedules.get(4).setDay("Friday");
                    schedules.get(4).setSlot1("B.Tech CSE");
                    schedules.get(4).setSlot2("B.Tech ESE");


                    teacher.setTeacherSchedules(schedules);

                }
            }
        });

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
        teacherName = findViewById(R.id.teacher_name);
        salary = findViewById(R.id.salary);
        subject = findViewById(R.id.subject);
        save=findViewById(R.id.save);
    }
}