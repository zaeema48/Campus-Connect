package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Adapter.SearchStudentAdapter;
import com.example.campusconnect.Adapter.SearchTeacherAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchTeacher extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchTeacherAdapter adapter;
    EditText name;
    AppCompatButton searchBtn;

    String teacherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_teacher);
        recyclerView=findViewById(R.id.searchTeacherRV);
        name=findViewById(R.id.teacher_name);
        searchBtn=findViewById(R.id.submitBtn);
        ProgressDialog progressDialog =new ProgressDialog(SearchTeacher.this);
        progressDialog.setTitle("Searching Teacher..");

        List<TeacherModel> teachers= new ArrayList<>();
        adapter=new SearchTeacherAdapter(SearchTeacher.this,teachers);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchTeacher.this));
        recyclerView.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherName=name.getText().toString();
                if(!teacherName.isEmpty()){
                    progressDialog.show();
                    ApiUtilities.getAdminApiInterface().searchTeacher(teacherName).enqueue(new Callback<List<TeacherModel>>() {
                        @Override
                        public void onResponse(Call<List<TeacherModel>> call, Response<List<TeacherModel>> response) {
                            teachers.clear();
                            progressDialog.dismiss();
                            if(!response.body().isEmpty())
                                teachers.addAll(response.body());
                            else
                                Toast.makeText(SearchTeacher.this, "No Teacher Was Found!!", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onFailure(Call<List<TeacherModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(SearchTeacher.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(SearchTeacher.this, "No Name has been entered!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}