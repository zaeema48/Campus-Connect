package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.R;
import com.example.campusconnect.Student.AttendancePercentage;
import com.example.campusconnect.Student.ViewAttendance;
import com.example.campusconnect.Student.ViewMarks;
import com.example.campusconnect.Student.StudentViewSchedule;

public class StudentHomeFragment extends Fragment {
    TextView schedule, view_attendance, view_marks, attendance_percent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_student_home, container, false);
       schedule=view.findViewById(R.id.viewSchedule);
       view_attendance=view.findViewById(R.id.viewAttendance);
       view_marks=view.findViewById(R.id.viewMarks);
       attendance_percent=view.findViewById(R.id.attendancePercent);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StudentViewSchedule.class);
                startActivity(intent);
            }
        });

        view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewAttendance.class);
                startActivity(intent);
            }
        });

        view_marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewMarks.class);
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

        return view;
    }
}