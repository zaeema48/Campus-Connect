package com.example.campusconnect.Fragments;

//Home fragment will contain list of all the micro-services  of admin

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusconnect.Admin.AddBatch;
import com.example.campusconnect.Admin.AddStudent;
import com.example.campusconnect.Admin.AddTeacher;
import com.example.campusconnect.Admin.BatchesList;
import com.example.campusconnect.Admin.ExamSchedule;
import com.example.campusconnect.Admin.RemoveStudent;
import com.example.campusconnect.Admin.RemoveTeacher;
import com.example.campusconnect.Admin.SearchBatch;
import com.example.campusconnect.Admin.SearchStudent;
import com.example.campusconnect.Admin.SearchTeacher;
import com.example.campusconnect.Admin.SubjectList;
import com.example.campusconnect.Admin.TeacherList;
import com.example.campusconnect.Admin.UpdateBatchSchedule;
import com.example.campusconnect.Admin.UpdateFees;
import com.example.campusconnect.Admin.UpdateSemester;
import com.example.campusconnect.Admin.UpdateTeacher;
import com.example.campusconnect.Admin.UpdateTeacherSchedule;
import com.example.campusconnect.R;

public class HomeFragment extends Fragment {
    CardView addBatch, batchList, searchBatch, updateSem, addStudent, removeStudent, updateStudent, searchStudent, updateBatchSchedule,
    addTeacher, removeTeacher, searchTeacher, teacherList, updateTeacher, subjectList, updateTeacherSchedule, updateFees, examSchedule;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//      FETCHING OF VIEWS
        addBatch = view.findViewById(R.id.addBatch);
        batchList = view.findViewById(R.id.batchList);
        searchBatch = view.findViewById(R.id.searchBatch);
        updateSem = view.findViewById(R.id.updateSem);
        addStudent = view.findViewById(R.id.addStudent);
        removeStudent = view.findViewById(R.id.removeStudent);
        updateStudent = view.findViewById(R.id.updateStudent);
        searchStudent = view.findViewById(R.id.searchStudent);
        updateBatchSchedule = view.findViewById(R.id.updateBatchSchedule);
        addTeacher = view.findViewById(R.id.addTeacher);
        removeTeacher = view.findViewById(R.id.removeTeacher);
        searchTeacher = view.findViewById(R.id.searchTeacher);
        teacherList = view.findViewById(R.id.teacherList);
        updateTeacher = view.findViewById(R.id.updateTeacher);
        subjectList = view.findViewById(R.id.subjectList);
        updateTeacherSchedule= view.findViewById(R.id.updateTeacherSchedule);
        updateFees = view.findViewById(R.id.updateFee);
        examSchedule = view.findViewById(R.id.examSchedule);

        addBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), AddBatch.class);
                startActivity(intent);
            }
        });

        batchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), BatchesList.class);
                startActivity(intent);
            }
        });

        searchBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), SearchBatch.class);
                startActivity(intent);
            }
        });

        updateSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), UpdateSemester.class);
                startActivity(intent);
            }
        });

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), AddStudent.class);
                startActivity(intent);
            }
        });

        removeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), RemoveStudent.class);
                startActivity(intent);
            }
        });

//        updateStudent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent (getContext(), UpdateStudent.class);
//                startActivity(intent);
//            }
//        });

        searchStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), SearchStudent.class);
                startActivity(intent);
            }
        });

        updateBatchSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), UpdateBatchSchedule.class);
                startActivity(intent);
            }
        });

        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), AddTeacher.class);
                startActivity(intent);
            }
        });

        removeTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), RemoveTeacher.class);
                startActivity(intent);
            }
        });

        searchTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), SearchTeacher.class);
                startActivity(intent);
            }
        });

        teacherList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), TeacherList.class);
                startActivity(intent);
            }
        });

        updateTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), UpdateTeacher.class);
                startActivity(intent);
            }
        });

        subjectList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), SubjectList.class);
                startActivity(intent);
            }
        });

        updateTeacherSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), UpdateTeacherSchedule.class);
                startActivity(intent);
            }
        });

        updateFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), UpdateFees.class);
                startActivity(intent);
            }
        });

        examSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getContext(), ExamSchedule.class);
                startActivity(intent);
            }
        });


        return view;

    }

}