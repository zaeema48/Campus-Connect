package com.example.campusconnect.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.campusconnect.Adapter.NoticeAdapter;
import com.example.campusconnect.AddNotice;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends Fragment {
    CardView addNew;
    SearchView search_bar;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        addNew=view.findViewById(R.id.addNew);
        search_bar=view.findViewById(R.id.search_bar);
        recyclerView=view.findViewById(R.id.notificationRV);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), AddNotice.class);
                startActivity(intent);
            }
        });

        List<NoticeModel> notices=new ArrayList<>();
        //TESTING DATA SETs
        NoticeModel notice1=new NoticeModel(12,"FEES REMINDER","THIS IS TO REMIND ALL THE STUDENTS AND PARENTS THAT THE LAST DATE OF PAYMENT OF FEES IS 24TH MARCH 2023 FAILING TO WHICH WOULD RESULT IN FINE");
        NoticeModel notice2=new NoticeModel(14,"FEES REMINDER 2","THIS IS TO REMIND ALL THE STUDENTS AND PARENTS THAT THE LAST DATE OF PAYMENT OF FEES HAS BEEN EXTENDED TO 30TH MARCH 2023 FAILING TO WHICH WOULD RESULT IN FINE");
        notices.add(notice1);
        notices.add(notice2);

        NoticeAdapter adapter=new NoticeAdapter(getContext(),notices);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        search_bar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                REST API WORKING
//                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return  view;
    }
}