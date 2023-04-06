package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.Admin.AdminPasswordChange;
import com.example.campusconnect.MainActivity;
import com.example.campusconnect.R;
import com.example.campusconnect.Teacher.ChangePassword;

public class ProfileFragment extends Fragment {

    androidx.appcompat.widget.AppCompatButton logout, changePswBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        logout=view.findViewById(R.id.logout);
        changePswBtn=view.findViewById(R.id.changePasw);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        changePswBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), AdminPasswordChange.class);
                startActivity(intent);
            }
        });

        return view;
    }
}