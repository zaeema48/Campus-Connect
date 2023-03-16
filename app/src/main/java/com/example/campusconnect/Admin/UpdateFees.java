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

public class UpdateFees extends AppCompatActivity {
    EditText sId, tId;
    AppCompatButton submit;

    String studentId, transactionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fees);
        sId=findViewById(R.id.studentId);
        tId=findViewById(R.id.transactionId);
        submit=findViewById(R.id.submit);
        ProgressDialog progressDialog= new ProgressDialog(UpdateFees.this);
        progressDialog.setTitle("Updating the fee status..");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentId=sId.getText().toString();
                transactionId=tId.getText().toString();
                if(!studentId.isEmpty() && !transactionId.isEmpty()){
                    progressDialog.show();
                    int studentID=Integer.parseInt(studentId);
                    ApiUtilities.getAdminApiInterface().UpdateFeeStatus(studentID,transactionId).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateFees.this, "Fee Status Updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateFees.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateFees.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(UpdateFees.this, "PLEASE FILL THE REQUIRED DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}