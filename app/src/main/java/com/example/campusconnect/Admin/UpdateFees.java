package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.R;

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentId=sId.getText().toString();
                transactionId=tId.getText().toString();
                if(!studentId.isEmpty() && !transactionId.isEmpty()){
//                    REST API WORK
                }
                else{
                    Toast.makeText(UpdateFees.this, "PLEASE FILL THE REQUIRED DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}