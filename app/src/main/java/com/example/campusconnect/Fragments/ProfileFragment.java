package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.campusconnect.MainActivity;
import com.example.campusconnect.R;

public class ProfileFragment extends Fragment {
    TextView name;
    androidx.appcompat.widget.AppCompatButton logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        name=view.findViewById(R.id.name);
        logout=view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}