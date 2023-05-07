package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.campusconnect.R;

public class BatchManagement extends AppCompatActivity {
    TextView addBatch, batchList, searchBatch, updateSem, examSchedule, updateBatchSchedule, addExamSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_management);
        addBatch = findViewById(R.id.addBatch);
        batchList = findViewById(R.id.batchList);
        searchBatch = findViewById(R.id.searchBatch);
        updateSem = findViewById(R.id.updateSem);
        examSchedule = findViewById(R.id.examSchedule);
        updateBatchSchedule = findViewById(R.id.updateBatchSchedule);
        addExamSchedule = findViewById(R.id.addExamSchedule);

        addBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BatchManagement.this, AddBatch.class);
                startActivity(intent);
            }
        });

        batchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BatchManagement.this, BatchesList.class);
                startActivity(intent);
            }
        });

        searchBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BatchManagement.this, SearchBatch.class);
                startActivity(intent);
            }
        });

        updateSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BatchManagement.this, UpdateSemester.class);
                startActivity(intent);
            }
        });

        updateBatchSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BatchManagement.this, UpdateBatchSchedule.class);
                startActivity(intent);
            }
        });

        addExamSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BatchManagement.this, AddExamSchedule.class);
                startActivity(intent);
            }
        });

        examSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BatchManagement.this, ExamSchedule.class);
                startActivity(intent);
            }
        });

    }
}