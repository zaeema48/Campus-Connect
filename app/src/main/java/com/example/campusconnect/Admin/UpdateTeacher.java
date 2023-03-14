package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.AdminPage;
import com.example.campusconnect.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateTeacher extends AppCompatActivity {

    EditText tId, sal;
    AppCompatButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);
        tId=findViewById(R.id.teacherId);
        sal=findViewById(R.id.salary);
        save=findViewById(R.id.save);
        ProgressDialog progressDialog= new ProgressDialog(UpdateTeacher.this);
        progressDialog.setTitle("Updating Teacher Salary..");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherId=tId.getText().toString();
                String salary=sal.getText().toString();
                if(!tId.getText().toString().isEmpty() && !salary.isEmpty()){
                    progressDialog.show();
                    int teacherID=Integer.valueOf(teacherId);
                    ApiUtilities.getAdminApiInterface().updateTeacher(teacherID,salary).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateTeacher.this, "Teacher Salary Updated.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(UpdateTeacher.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateTeacher.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(UpdateTeacher.this, "INSUFFICIENT DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}