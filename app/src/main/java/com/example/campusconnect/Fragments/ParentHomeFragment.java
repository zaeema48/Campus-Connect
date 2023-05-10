package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.Parent.AttendancePercentage;
import com.example.campusconnect.Parent.ChildAttendance;
import com.example.campusconnect.Parent.ChildClassSchedule;
import com.example.campusconnect.Parent.ChildExamSchedule;
import com.example.campusconnect.Parent.ChildSubjectMarks;
import com.example.campusconnect.R;
import com.example.campusconnect.Student.ViewAttendance;
import com.example.campusconnect.Student.ViewExamSchedule;
import com.example.campusconnect.Student.ViewMarks;

public class ParentHomeFragment extends Fragment {

    TextView schedule, view_attendance, view_result, attendance_percent, exam_schedule;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_parent_home, container, false);

        schedule=view.findViewById(R.id.viewSchedule);
        view_attendance=view.findViewById(R.id.viewAttendance);
        view_result=view.findViewById(R.id.viewResult);
        attendance_percent=view.findViewById(R.id.attendancePercent);
        exam_schedule= view.findViewById(R.id.examSchedule);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), ChildClassSchedule.class);
                startActivity(intent);
            }
        });

        view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChildAttendance.class);
                startActivity(intent);
            }
        });

        view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChildSubjectMarks.class);
                startActivity(intent);
            }
        });

        attendance_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AttendancePercentage.class);
                startActivity(intent);
            }
        });

        exam_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChildExamSchedule.class);
                startActivity(intent);
            }
        });

        return view;
    }
}