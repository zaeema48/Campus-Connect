package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.R;
import com.example.campusconnect.Teacher.MarkAttendance;
import com.example.campusconnect.Teacher.SearchAvailableSlots;
import com.example.campusconnect.Teacher.UploadMarks;
import com.example.campusconnect.Teacher.ViewBatchAttendance;
import com.example.campusconnect.Teacher.ViewSchedule;
import com.example.campusconnect.Teacher.ViewStudentAttendance;

public class TeacherHomeFragment extends Fragment {
TextView schedule, student_attendance, batch_attendance, mark_attendance, upload_marks, available_slots;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_teacher_home, container, false);
            schedule=view.findViewById(R.id.viewSchedule);
            student_attendance=view.findViewById(R.id.viewStudentAttendance);
            batch_attendance=view.findViewById(R.id.viewBatchAttendance);
            mark_attendance=view.findViewById(R.id.viewStudentAttendance);
            upload_marks=view.findViewById(R.id.uploadMarks);
            available_slots=view.findViewById(R.id.availableSlots);

            schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ViewSchedule.class);
                    startActivity(intent);
                }
            });

            student_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ViewStudentAttendance.class);
                    startActivity(intent);
                }
            });

            batch_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ViewBatchAttendance.class);
                    startActivity(intent);
                }
            });

            mark_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MarkAttendance.class);
                    startActivity(intent);
                }
            });

            upload_marks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), UploadMarks.class);
                    startActivity(intent);
                }
            });

            available_slots.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), SearchAvailableSlots.class);
                    startActivity(intent);
                }
            });
        return view;
    }
}