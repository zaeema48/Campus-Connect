
package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.R;

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batchId=bId.getText().toString();
                currSem=curSem.getText().toString();
                if(!batchId.isEmpty() && !currSem.isEmpty()){
//                    REST API WORK
                }
                else {
                    Toast.makeText(UpdateSemester.this, "PLEASE FILL THE REQUIRED DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}