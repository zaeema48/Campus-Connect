package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.TeacherListAdapter;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherList extends AppCompatActivity {

    RecyclerView recyclerView;
    TeacherListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        recyclerView=findViewById(R.id.teacherListRV);
        ProgressDialog progressDialog = new ProgressDialog(TeacherList.this);
        progressDialog.setTitle("Fetching Teachers List..");
        progressDialog.show();

        List<TeacherModel> teachers = new ArrayList<>();
        adapter=new TeacherListAdapter(TeacherList.this,teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(TeacherList.this));
        recyclerView.setAdapter(adapter);

        ApiUtilities.getAdminApiInterface().teacherList().enqueue(new Callback<List<TeacherModel>>() {
            @Override
            public void onResponse(Call<List<TeacherModel>> call, Response<List<TeacherModel>> response) {
                teachers.clear();
                teachers.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<TeacherModel>> call, Throwable t) {
                Toast.makeText(TeacherList.this, "An Error Has Occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }
}