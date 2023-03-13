package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.BatchListAdapter;
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BatchesList extends AppCompatActivity {

    RecyclerView recyclerView;
    BatchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batches_list);
        recyclerView=findViewById(R.id.batchListRV);
        List<BatchModel> batches= new ArrayList<>();

        ProgressDialog progressDialog= new ProgressDialog(BatchesList.this);
        progressDialog.setTitle("Fetching the Data...");
        progressDialog.show();

        adapter=new BatchListAdapter(BatchesList.this,batches);
        recyclerView.setLayoutManager(new LinearLayoutManager(BatchesList.this));
        recyclerView.setAdapter(adapter);

        ApiUtilities.getAdminApiInterface().getBatch().enqueue(new Callback<List<BatchModel>>() {
            @Override
            public void onResponse(Call<List<BatchModel>> call, Response<List<BatchModel>> response) {
                progressDialog.dismiss();
                batches.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<BatchModel>> call, Throwable t) {
                Toast.makeText(BatchesList.this, "An Error has Occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }
}