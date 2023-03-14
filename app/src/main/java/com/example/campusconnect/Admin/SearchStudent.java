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
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchStudentAdapter adapter;
    EditText name;
    AppCompatButton submitBtn;

    String studentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        recyclerView= findViewById(R.id.searchStudentRV);
        name=findViewById(R.id.student_name);
        submitBtn=findViewById(R.id.submitBtn);
        ProgressDialog progressDialog = new ProgressDialog(SearchStudent.this);
        progressDialog.setTitle("Searching Student..");

        List<StudentModel> students= new ArrayList<>();
        adapter=new SearchStudentAdapter(SearchStudent.this,students);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchStudent.this));
        recyclerView.setAdapter(adapter);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentName=name.getText().toString();
                if(!studentName.isEmpty()){
                    progressDialog.show();
                    ApiUtilities.getAdminApiInterface().searchStudent(studentName).enqueue(new Callback<List<StudentModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                            students.clear();
                            if(!response.body().isEmpty())
                                students.addAll(response.body());
                            else
                                Toast.makeText(SearchStudent.this, "No Student Was Found!!", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(SearchStudent.this, "An Error Has Occurred!! ", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else{
                    Toast.makeText(SearchStudent.this, "Enter The Student Name!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}