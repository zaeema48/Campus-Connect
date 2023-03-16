package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.Models.NoticeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNotice extends AppCompatActivity {
    EditText title, noticeBody;
    CardView save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);
        title=findViewById(R.id.title);
        noticeBody=findViewById(R.id.notice);
        save=findViewById(R.id.save);

        ProgressDialog progressDialog= new ProgressDialog(AddNotice.this);
        progressDialog.setTitle("Adding Notice..");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty() && !noticeBody.getText().toString().isEmpty()){
                    progressDialog.show();
                    NoticeModel notice= new NoticeModel();
                    notice.setNotificationTitle(title.getText().toString());
                    notice.setNotificationMessage(noticeBody.getText().toString());

                    ApiUtilities.getAdminApiInterface().addNotice(notice).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(AddNotice.this, "Notice Uploaded Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(AddNotice.this,AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(AddNotice.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                    Toast.makeText(AddNotice.this, "PLEASE COMPLETE THE NOTICE!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}