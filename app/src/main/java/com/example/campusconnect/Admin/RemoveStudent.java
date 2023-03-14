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

public class RemoveStudent extends AppCompatActivity {

    EditText sID;
    AppCompatButton submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_student);

        sID=findViewById(R.id.student_id);
        submit=findViewById(R.id.submitBtn);
        ProgressDialog progressDialog= new ProgressDialog(RemoveStudent.this);
        progressDialog.setTitle("Removing Student..");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sID.getText().toString().isEmpty()){
                    progressDialog.show();
                    int studentId= Integer.parseInt(sID.getText().toString());
                    ApiUtilities.getAdminApiInterface().removeStudent(studentId).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(RemoveStudent.this, "Student Removed Successfully.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(RemoveStudent.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(RemoveStudent.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(RemoveStudent.this, "Enter The Student ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}