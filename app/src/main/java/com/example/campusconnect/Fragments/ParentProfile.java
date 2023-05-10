package com.example.campusconnect.Fragments;

import static com.example.campusconnect.ParentLogin.publicParent;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.MainActivity;
import com.example.campusconnect.Parent.ParentPasswordChange;
import com.example.campusconnect.R;
import com.example.campusconnect.Student.StudentPasswordChange;

public class ParentProfile extends Fragment {

    AppCompatButton logoutBtn, changePswBtn;
    TextView name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_parent_profile, container, false);

        logoutBtn=view.findViewById(R.id.logout);
        changePswBtn=view.findViewById(R.id.changePasw);
        name=view.findViewById(R.id.name);

        name.setText(publicParent.getName());

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        changePswBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), ParentPasswordChange.class);
                startActivity(intent);
            }
        });

        return view;
    }
}