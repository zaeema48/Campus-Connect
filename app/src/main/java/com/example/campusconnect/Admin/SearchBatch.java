package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.campusconnect.Adapter.StudentListAdapter;
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class SearchBatch extends AppCompatActivity {
    TextView m1,  m2, m3, m4, m5, t1, t2, t3, t4, t5, w1, w2, w3, w4, w5, th1, th2, th3, th4, th5, f1, f2, f3, f4, f5;
    TextView batchId, cYear,cName,cDuration,cFees,currSem;
    androidx.appcompat.widget.SearchView searchBar;
    RecyclerView recyclerView;
    StudentListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_batch);
        fetchView();
//        BatchModel batch = new BatchModel();
        searchBar.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //REST API CALLING AND WORKING (retrofit)
//                batch=
                BatchModel batch=new BatchModel("BTechCSE2019","BTechCSE","2019","8th Semester", "90K","7th Semester");
                StudentModel student1=new StudentModel();
                student1.setStudentId(123);
                student1.setStudentName("Zeeshan");
                StudentModel student2= new StudentModel();
                student2.setStudentId(234);
                student2.setStudentName("Zaeema");
                List<StudentModel> students=new ArrayList<>();
                students.add(student1);
                students.add(student2);
                batch.setStudents(students);



                setView(batch);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    public void setView(BatchModel batch){
        batchId.setText(batch.getBatchId());
        cYear.setText(batch.getCourseYear());
        cName.setText(batch.getCourseName());
        cDuration.setText(batch.getCourseDuration());
        cFees.setText(batch.getFeesAmount());
        currSem.setText(batch.getCurrentSemester());

        List<StudentModel> students=new ArrayList<>();
        students=batch.getStudents();
        //SETTING ADAPTER IN RV
        adapter=new StudentListAdapter(SearchBatch.this,students);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchBatch.this));
        recyclerView.setAdapter(adapter);

        //SETTING TABLE VIEW
//        List<ScheduleModel> schedules=new ArrayList<>();
//        schedules=batch.getSchedules();
//        m1.setText(schedules.get(0).getSlot1());
//        m2.setText(schedules.get(0).getSlot2());
//        m3.setText(schedules.get(0).getSlot3());
//        m4.setText(schedules.get(0).getSlot4());
//        m5.setText(schedules.get(0).getSlot5());
//
//        t1.setText(schedules.get(1).getSlot1());
//        t2.setText(schedules.get(1).getSlot2());
//        t3.setText(schedules.get(1).getSlot3());
//        t4.setText(schedules.get(1).getSlot4());
//        t5.setText(schedules.get(1).getSlot5());
//
//        w1.setText(schedules.get(2).getSlot1());
//        w2.setText(schedules.get(2).getSlot2());
//        w3.setText(schedules.get(2).getSlot3());
//        w4.setText(schedules.get(2).getSlot4());
//        w5.setText(schedules.get(2).getSlot5());
//
//        th1.setText(schedules.get(3).getSlot1());
//        th2.setText(schedules.get(3).getSlot2());
//        th3.setText(schedules.get(3).getSlot3());
//        th4.setText(schedules.get(3).getSlot4());
//        th5.setText(schedules.get(3).getSlot5());
//
//        f1.setText(schedules.get(4).getSlot1());
//        f2.setText(schedules.get(4).getSlot2());
//        f3.setText(schedules.get(4).getSlot3());
//        f4.setText(schedules.get(4).getSlot4());
//        f5.setText(schedules.get(4).getSlot5());
    }

    public void fetchView(){
        searchBar=findViewById(R.id.search_bar);
        batchId=findViewById(R.id.batchId);
        cYear=findViewById(R.id.cYear);
        cName=findViewById(R.id.cName);
        cDuration=findViewById(R.id.cDuration);
        cFees=findViewById(R.id.cFees);
        currSem=findViewById(R.id.curSem);
        recyclerView=findViewById(R.id.studentListRV);
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