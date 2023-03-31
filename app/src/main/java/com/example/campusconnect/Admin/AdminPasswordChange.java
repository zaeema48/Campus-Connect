package com.example.campusconnect.Admin;

import static com.example.campusconnect.AdminPage.publicAdmin;
import static com.example.campusconnect.TeacherPage.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.R;
import com.example.campusconnect.Teacher.ChangePassword;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPasswordChange extends AppCompatActivity {
    EditText oldPasw, newPasw, rePasw;
    TextView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_password_change);
        oldPasw=findViewById(R.id.oldPasw);
        newPasw=findViewById(R.id.newPasw);
        rePasw=findViewById(R.id.rePasw);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPassword=oldPasw.getText().toString();
                String newPassword=newPasw.getText().toString();
                String rePassword=rePasw.getText().toString();

                ProgressDialog progressDialog =new ProgressDialog(AdminPasswordChange.this);
                progressDialog.setTitle("Saving New Password..");

                if(!oldPassword.isEmpty() && !newPassword.isEmpty() && !rePassword.isEmpty()){
                    progressDialog.show();
                    if(!oldPassword.equals(publicAdmin.getPassword())){
                        progressDialog.dismiss();
                        Toast.makeText(AdminPasswordChange.this, "Old Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                    else if(!newPassword.equals(rePassword)){
                        progressDialog.dismiss();
                        Toast.makeText(AdminPasswordChange.this, "The New Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ApiUtilities.getAdminApiInterface().changePassword(publicAdmin.getAdminId(), oldPassword, newPassword).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                progressDialog.dismiss();
                                Toast.makeText(AdminPasswordChange.this, "Password changed successfully.", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(AdminPasswordChange.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                else{
                    Toast.makeText(AdminPasswordChange.this, "Please enter the required details!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}