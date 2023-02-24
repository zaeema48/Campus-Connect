package com.example.campusconnect.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusconnect.R;

public class HomeFragment extends Fragment {
    CardView addBatch, batchList, searchBatch, updateSem, addStudent, removeStudent, updateStudent, searchStudent, updateStudentSchedule,
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
        updateStudentSchedule = view.findViewById(R.id.updateStudentSchedule);
        addTeacher = view.findViewById(R.id.addTeacher);
        removeTeacher = view.findViewById(R.id.removeTeacher);
        searchTeacher = view.findViewById(R.id.searchTeacher);
        teacherList = view.findViewById(R.id.teacherList);
        updateTeacher = view.findViewById(R.id.updateTeacher);
        subjectList = view.findViewById(R.id.subjectList);
        updateTeacherSchedule= view.findViewById(R.id.updateTeacherSchedule);
        updateFees = view.findViewById(R.id.updateFee);
        examSchedule = view.findViewById(R.id.examSchedule);

        return view;
    }


}