package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.R;

public class RemoveTeacher extends AppCompatActivity {

    EditText tID;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_teacher);

        tID=findViewById(R.id.teacher_id);
        submit=findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tID.getText().toString().isEmpty()){
                    int teacherId= Integer.parseInt(tID.getText().toString());
                    //CONNECTING REST API (retrofit)
                }
                else {
                    Toast.makeText(RemoveTeacher.this, "Enter the Teacher ID!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}