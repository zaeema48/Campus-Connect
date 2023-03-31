package com.example.campusconnect.Teacher;

import static com.example.campusconnect.TeacherPage.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassword extends AppCompatActivity {
    EditText oldPasw, newPasw, rePasw;
    TextView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldPasw=findViewById(R.id.oldPasw);
        newPasw=findViewById(R.id.newPasw);
        rePasw=findViewById(R.id.rePasw);
        save=findViewById(R.id.save);

        ProgressDialog progressDialog =new ProgressDialog(ChangePassword.this);
        progressDialog.setTitle("Saving New Password..");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPassword=oldPasw.getText().toString();
                String newPassword=newPasw.getText().toString();
                String rePassword=rePasw.getText().toString();

                if(!oldPassword.isEmpty() && !newPassword.isEmpty() && !rePassword.isEmpty()){
                    progressDialog.show();
                    if(!oldPassword.equals(publicTeacher.getTeacherPassword())){
                        progressDialog.dismiss();
                        Toast.makeText(ChangePassword.this, "Old Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                    else if(!newPassword.equals(rePassword)){
                        progressDialog.dismiss();
                        Toast.makeText(ChangePassword.this, "The New Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        TeacherApi.getTeacherApiInterface().changeTeacherPassword(publicTeacher.getTeacherId(),oldPassword,newPassword).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                progressDialog.dismiss();
                                Toast.makeText(ChangePassword.this, "Password changed Successfully", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(ChangePassword.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                else{
                    Toast.makeText(ChangePassword.this, "Please enter the required details!!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}