package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Models.AdminModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminLogin extends AppCompatActivity {
    EditText adminId, password;
    CardView button;
    public static AdminModel publicAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminId = findViewById(R.id.adminId);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        ProgressDialog progressDialog = new ProgressDialog(AdminLogin.this);
        progressDialog.setTitle("Signing In..");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin_id=adminId.getText().toString();
                String admin_password=password.getText().toString();

               if(!admin_id.isEmpty() && !admin_password.isEmpty()) {
                   progressDialog.show();
                   ApiUtilities.getAdminApiInterface().adminLogin(admin_id,admin_password).enqueue(new Callback<AdminModel>() {
                       @Override
                       public void onResponse(Call<AdminModel> call, Response<AdminModel> response) {
                           progressDialog.dismiss();
                           if(response.body()!=null) {
                               AdminModel admin = response.body();
                               Intent intent= new Intent(AdminLogin.this,AdminPage.class);
                               publicAdmin=admin;
                               startActivity(intent);
                           }
                           else
                               Toast.makeText(AdminLogin.this, "User Id Or Password is Incorrect!!", Toast.LENGTH_SHORT).show();
                       }

                       @Override
                       public void onFailure(Call<AdminModel> call, Throwable t) {
                           progressDialog.dismiss();
                           Toast.makeText(AdminLogin.this, "User Id Or Password is Incorrect!!", Toast.LENGTH_SHORT).show();
                       }
                   });

               }

               else{
                   Toast.makeText(AdminLogin.this, "Please Enter the User Id and Password!!", Toast.LENGTH_SHORT).show();
               }
            }

        });

    }

}