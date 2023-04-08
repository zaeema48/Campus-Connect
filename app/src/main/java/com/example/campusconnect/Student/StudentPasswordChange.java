package com.example.campusconnect.Student;

import static com.example.campusconnect.StudentLogin.publicStudent;
import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.R;
import com.example.campusconnect.Teacher.ChangePassword;
import com.example.campusconnect.TeacherPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentPasswordChange extends AppCompatActivity {
    EditText oldPasw, newPasw, rePasw;
    CardView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_password_change);

        oldPasw=findViewById(R.id.oldPasw);
        newPasw=findViewById(R.id.newPasw);
        rePasw=findViewById(R.id.rePasw);
        save=findViewById(R.id.save);

        ProgressDialog progressDialog =new ProgressDialog(StudentPasswordChange.this);
        progressDialog.setTitle("Saving New Password..");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPassword=oldPasw.getText().toString();
                String newPassword=newPasw.getText().toString();
                String rePassword=rePasw.getText().toString();

                if(!oldPassword.isEmpty() && !newPassword.isEmpty() && !rePassword.isEmpty()){
                    progressDialog.show();
                    if(!oldPassword.equals(publicStudent.getPassword())){
                        progressDialog.dismiss();
                        Toast.makeText(StudentPasswordChange.this, "Old Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                    else if(!newPassword.equals(rePassword)){
                        progressDialog.dismiss();
                        Toast.makeText(StudentPasswordChange.this, "The New Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        StudentAPI.getStudentApiInterface().passwordChange(publicStudent.getStudentId(),newPassword).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                progressDialog.dismiss();
                                Toast.makeText(StudentPasswordChange.this, "Password changed Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(StudentPasswordChange.this, TeacherPage.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(StudentPasswordChange.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                            }
                        });
//
                    }
                }
                else{
                    Toast.makeText(StudentPasswordChange.this, "Please enter the required details!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}