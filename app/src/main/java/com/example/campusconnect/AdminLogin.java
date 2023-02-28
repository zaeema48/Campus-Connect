package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.Models.AdminModel;

public class AdminLogin extends AppCompatActivity {
EditText adminId, password;
CardView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        AdminModel admin = new AdminModel();

        adminId = findViewById(R.id.adminId);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin_id=adminId.getText().toString();
                String admin_password=password.getText().toString();
               if(!admin_id.isEmpty() && !admin_password.isEmpty()) {
                   admin.setAdminId(admin_id);
                   admin.setPassword(admin_password);
                   Intent intent = new Intent(AdminLogin.this, AdminPage.class);
                   startActivity(intent);
               }

               else{
                   Toast.makeText(AdminLogin.this, "Enter the correct credentials", Toast.LENGTH_SHORT).show();
               }
            }

        });

    }

}