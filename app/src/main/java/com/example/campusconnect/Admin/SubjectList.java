package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.SubjectListAdapter;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectList extends AppCompatActivity {

    RecyclerView recyclerView;
    SubjectListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        recyclerView=findViewById(R.id.subjectListRV);

        ProgressDialog progressDialog= new ProgressDialog(SubjectList.this);
        progressDialog.setTitle("Fetching Subject List..");

        List<SubjectModel> subjectList = new ArrayList<>();
        adapter = new SubjectListAdapter(SubjectList.this, subjectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectList.this));
        recyclerView.setAdapter(adapter);

        ApiUtilities.getAdminApiInterface().subjectList().enqueue(new Callback<List<SubjectModel>>() {
            @Override
            public void onResponse(Call<List<SubjectModel>> call, Response<List<SubjectModel>> response) {
                progressDialog.show();
                subjectList.clear();
                subjectList.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<SubjectModel>> call, Throwable t) {
                Toast.makeText(SubjectList.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}