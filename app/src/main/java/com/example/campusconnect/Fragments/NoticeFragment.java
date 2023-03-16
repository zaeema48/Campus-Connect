package com.example.campusconnect.Fragments;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.NoticeAdapter;
import com.example.campusconnect.AddNotice;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeFragment extends Fragment {
    CardView addNew;
    SearchView search_bar;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        addNew=view.findViewById(R.id.addNew);
        search_bar=view.findViewById(R.id.search_bar);
        recyclerView=view.findViewById(R.id.notificationRV);

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Searching The Notices..");

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), AddNotice.class);
                startActivity(intent);
            }
        });

        List<NoticeModel> notices= new ArrayList<>();
        NoticeAdapter adapter=new NoticeAdapter(getContext(),notices);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        ApiUtilities.getAdminApiInterface().allNotices().enqueue(new Callback<List<NoticeModel>>() {
            @Override
            public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                notices.clear();
                notices.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NoticeModel>> call, Throwable t) {
                Toast.makeText(getContext(), "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });

        search_bar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.show();
//                REST API WORKING
                ApiUtilities.getAdminApiInterface().searchNotice(query).enqueue(new Callback<List<NoticeModel>>() {
                    @Override
                    public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                        notices.clear();
                        notices.addAll(response.body());
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<List<NoticeModel>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                    }
                });
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