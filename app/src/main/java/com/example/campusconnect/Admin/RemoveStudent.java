package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.R;

public class RemoveStudent extends AppCompatActivity {

    EditText sID;
    AppCompatButton submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_student);

        sID=findViewById(R.id.student_id);
        submit=findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sID.getText().toString().isEmpty()){
                    int studentId= Integer.parseInt(sID.getText().toString());
                    //CONNECTING REST API (retrofit)
                }
                else {
                    Toast.makeText(RemoveStudent.this, "Enter the Student ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}