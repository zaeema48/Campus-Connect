package com.example.campusconnect.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Adapter.NoticeAdapter;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewNoticeFragment extends Fragment {

    SearchView search_bar;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_notice, container, false);
        search_bar=view.findViewById(R.id.search_bar);
        recyclerView=view.findViewById(R.id.notificationRV);

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Searching The Notices..");

        List<NoticeModel> notices= new ArrayList<>();
        NoticeAdapter adapter=new NoticeAdapter(getContext(),notices);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        StudentAPI.getStudentApiInterface().getNotices().enqueue(new Callback<List<NoticeModel>>() {
            @Override
            public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                if(response.body()!=null) {
                    notices.clear();
                    notices.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
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
                StudentAPI.getStudentApiInterface().searchNotices(query).enqueue(new Callback<List<NoticeModel>>() {
                    @Override
                    public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                        if(response.body()!=null) {
                            notices.clear();
                            notices.addAll(response.body());
                            adapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }
                        if(notices.isEmpty()){
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Nothing Found!!", Toast.LENGTH_SHORT).show();
                        }
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


        return view;
    }
}