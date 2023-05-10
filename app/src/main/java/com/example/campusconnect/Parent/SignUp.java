package com.example.campusconnect.Parent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.campusconnect.API.ParentAPI;
import com.example.campusconnect.Models.ParentModel;
import com.example.campusconnect.ParentLogin;
import com.example.campusconnect.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    EditText pEmail, pasw, sId;
    CardView sigUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        pEmail=findViewById(R.id.parent_email);
        pasw=findViewById(R.id.password);
        sId=findViewById(R.id.student_id);
        sigUp=findViewById(R.id.sign_up);

        sigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parentEmail,password, studentId;
                parentEmail=pEmail.getText().toString();
                password=pasw.getText().toString();
                studentId=sId.getText().toString();

                ProgressDialog progressDialog= new ProgressDialog(SignUp.this);
                progressDialog.setTitle("Creating the Account...");
                if(!parentEmail.isEmpty()&& !password.isEmpty() && !studentId.isEmpty()){
                    progressDialog.show();
                    ParentModel parent = new ParentModel();
                    parent.setParentEmail(parentEmail);
                    parent.setPassword(password);

                    ParentAPI.getParentApiInterface().parentSignup(Integer.parseInt(studentId), parent).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(SignUp.this, "Kindly check your mail for unique Parent Id.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUp.this, ParentLogin.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(SignUp.this, "Parent account already exist for this Student!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(SignUp.this, "Please fill all the fields!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}