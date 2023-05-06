package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ParentLogin extends AppCompatActivity {
EditText id, pass;
CardView button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        id=findViewById(R.id.parentId);
        pass=findViewById(R.id.pas);
        button=findViewById(R.id.bt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parentId=id.getText().toString();
                String password=pass.getText().toString();

                if(!parentId.isEmpty() && !password.isEmpty()){

                    Intent intent = new Intent(ParentLogin.this, ParentPage.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });
    }
}