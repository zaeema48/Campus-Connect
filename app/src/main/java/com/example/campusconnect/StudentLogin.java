package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.API.StudentApiInterface;
import com.example.campusconnect.Models.StudentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLogin extends AppCompatActivity {
EditText id, password;
CardView button;

public static StudentModel publicStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        id=findViewById(R.id.studentId);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);

        ProgressDialog progressDialog= new ProgressDialog(StudentLogin.this);
        progressDialog.setTitle("Signing...");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentId=id.getText().toString();
                String studentPassword=password.getText().toString();
                if(!studentId.isEmpty() && !studentPassword.isEmpty()){
                    progressDialog.show();
                    StudentAPI.getStudentApiInterface().studentLogin(Integer.parseInt(studentId), studentPassword).enqueue(new Callback<StudentModel>() {
                        @Override
                        public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                            publicStudent=response.body();
                            Intent intent = new Intent(StudentLogin.this, StudentPage.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<StudentModel> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(StudentLogin.this, "Wrong Credentials!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(StudentLogin.this, "Enter User Id and Password!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}