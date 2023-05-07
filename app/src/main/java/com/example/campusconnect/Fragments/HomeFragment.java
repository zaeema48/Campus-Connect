package com.example.campusconnect.Fragments;

//Home fragment will contain list of all the micro-services  of admin

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.Admin.BatchManagement;
import com.example.campusconnect.Admin.StudentManagement;
import com.example.campusconnect.Admin.TeacherManagement;
import com.example.campusconnect.R;

public class HomeFragment extends Fragment {
    TextView batchManagement, teacherManagement, studentManagement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//      FETCHING OF VIEWS
        batchManagement= view.findViewById(R.id.batch_management);
        teacherManagement= view.findViewById(R.id.teacher_management);
        studentManagement= view.findViewById(R.id.student_management);

        batchManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BatchManagement.class);
                startActivity(intent);
            }
        });
        teacherManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), TeacherManagement.class);
                startActivity(intent);
            }
        });
        studentManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), StudentManagement.class);
                startActivity(intent);
            }
        });

        return view;

    }

}