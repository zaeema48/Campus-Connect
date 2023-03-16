
package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.AdminPage;
import com.example.campusconnect.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateSemester extends AppCompatActivity {
    EditText bId, curSem;
    AppCompatButton submit;
    String batchId,currSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_semester);
        bId=findViewById(R.id.batchId);
        curSem=findViewById(R.id.curSem);
        submit=findViewById(R.id.submit);
        ProgressDialog progressDialog = new ProgressDialog(UpdateSemester.this);
        progressDialog.setTitle("Updating Semester Details..");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batchId=bId.getText().toString();
                currSem=curSem.getText().toString();
                if(!batchId.isEmpty() && !currSem.isEmpty()){
                    progressDialog.show();
                    ApiUtilities.getAdminApiInterface().updateBatchSemester(batchId,currSem).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateSemester.this, "Semester Details Has been Updated", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(UpdateSemester.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateSemester.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(UpdateSemester.this, "PLEASE FILL THE REQUIRED DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}