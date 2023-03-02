package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.campusconnect.Adapter.BatchListAdapter;
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class BatchesList extends AppCompatActivity {

    RecyclerView recyclerView;
    BatchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batches_list);
        recyclerView=findViewById(R.id.batchListRV);
        ArrayList<BatchModel> batches= new ArrayList<>();
        //TESTING DATA SET
        BatchModel batch= new BatchModel();
        batch.setBatchId("BTech2019");
        batch.setCourseName("BTechCSE");
        batch.setCourseYear("2019");
        batch.setCourseDuration("4 year");
        batch.setFeesAmount("85k");
        batch.setCurrentSemester("8th Sem");
        batches.add(batch);
        BatchModel batch2= new BatchModel();
        batch2.setBatchId("BTech2020");
        batch2.setCourseName("BTechCSE");
        batch2.setCourseYear("2020");
        batch2.setCourseDuration("4 year");
        batch2.setFeesAmount("90k");
        batch2.setCurrentSemester("6th Sem");
        batches.add(batch2);

        adapter=new BatchListAdapter(BatchesList.this,batches);
        recyclerView.setLayoutManager(new LinearLayoutManager(BatchesList.this));
        recyclerView.setAdapter(adapter);

    }
}