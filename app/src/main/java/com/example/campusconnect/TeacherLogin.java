package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Models.TeacherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherLogin extends AppCompatActivity {
    EditText tId, password;
    CardView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        tId=findViewById(R.id.teacherId);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);

        ProgressDialog progressDialog = new ProgressDialog(TeacherLogin.this);
        progressDialog.setTitle("Signing In..");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacher_id= tId.getText().toString();
                String teacherPassword=password.getText().toString();

                if(teacher_id!=null && teacherPassword!=null){
                    progressDialog.show();
                    int teacherId=Integer.parseInt(teacher_id);
                    TeacherApi.getTeacherApiInterface().teacherLogin(teacherId, teacherPassword).enqueue(new Callback<TeacherModel>() {
                        @Override
                        public void onResponse(Call<TeacherModel> call, Response<TeacherModel> response) {
                            progressDialog.dismiss();
                            if(response.body()!=null){
                                TeacherModel teacher=response.body();
                                Intent intent= new Intent(TeacherLogin.this,TeacherPage.class);
                                intent.putExtra("teacherId",teacher.getTeacherId());
                                intent.putExtra("teacherName",teacher.getTeacherName());
                                intent.putExtra("teacherPaswd",teacher.getTeacherPassword());
                                intent.putExtra("subjectId",teacher.getSubject().getSubjectId());
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(TeacherLogin.this, "User Id Or Password is Incorrect!!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<TeacherModel> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(TeacherLogin.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                    Toast.makeText(TeacherLogin.this, "Enter the correct credentials!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}