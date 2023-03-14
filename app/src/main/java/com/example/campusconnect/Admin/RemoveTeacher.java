package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
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

public class RemoveTeacher extends AppCompatActivity {

    EditText tID;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_teacher);

        tID=findViewById(R.id.teacher_id);
        submit=findViewById(R.id.submitBtn);
        ProgressDialog progressDialog = new ProgressDialog(RemoveTeacher.this);
        progressDialog.setTitle("Removing Teacher..");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tID.getText().toString().isEmpty()){
                    progressDialog.show();
                    int teacherId= Integer.parseInt(tID.getText().toString());
                    ApiUtilities.getAdminApiInterface().removeTeacher(teacherId).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(RemoveTeacher.this, "Teacher Removed Successfully.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(RemoveTeacher.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(RemoveTeacher.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(RemoveTeacher.this, "Enter the Teacher ID!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}