package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campusconnect.API.ParentAPI;
import com.example.campusconnect.Models.ParentModel;
import com.example.campusconnect.Parent.SignUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentLogin extends AppCompatActivity {
    EditText id, pass;
    TextView signUp;
    CardView signIn;

    public static int chidId;
    public static ParentModel parent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        id=findViewById(R.id.parentId);
        pass=findViewById(R.id.pas);
        signIn=findViewById(R.id.bt);
        signUp=findViewById(R.id.signUp);

        ProgressDialog progressDialog = new ProgressDialog(ParentLogin.this);
        progressDialog.setTitle("Signing in...");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parentId=id.getText().toString();
                String password=pass.getText().toString();

                if(!parentId.isEmpty() && !password.isEmpty()){
                    progressDialog.show();
                    int pId=Integer.parseInt(parentId);
                    ParentAPI.getParentApiInterface().parentLogin(pId, password).enqueue(new Callback<ParentModel>() {
                        @Override
                        public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                            parent=response.body();
                            progressDialog.dismiss();
                            if(parent==null)
                                Toast.makeText(ParentLogin.this, "Parent credential is Incorrect!!", Toast.LENGTH_SHORT).show();

                            else {
                                Intent intent = new Intent(ParentLogin.this, ParentPage.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ParentModel> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(ParentLogin.this, "Parent credential is Incorrect!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ParentLogin.this, "Please enter the Parent Credential!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ParentLogin.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}