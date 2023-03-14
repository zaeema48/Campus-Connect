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
                   Intent intent = new Intent(AdminLogin.this, AdminPage.class);
                   startActivity(intent);

//                   ApiUtilities.getAdminApiInterface().adminLogin(admin_id,admin_password).enqueue(new Callback<String>() {
//                       @Override
//                       public void onResponse(Call<String> call, Response<String> response) {
//                           progressDialog.dismiss();
//                           if(response.body().equals("Login SuccessFull.")) {
//                               Intent intent = new Intent(AdminLogin.this, AdminPage.class);
//                               startActivity(intent);
//                           }
//                           else
//                               Toast.makeText(AdminLogin.this, "UserId or Password is incorrect!!", Toast.LENGTH_SHORT).show();
//                       }
//
//                       @Override
//                       public void onFailure(Call<String> call, Throwable t) {
//                           progressDialog.dismiss();
//                           Toast.makeText(AdminLogin.this, "An Error Has Occurred!!"+t, Toast.LENGTH_SHORT).show();
//
//                       }
//                   });

               }

               else{
                   Toast.makeText(AdminLogin.this, "Enter the correct credentials", Toast.LENGTH_SHORT).show();
               }
            }

        });

    }

}