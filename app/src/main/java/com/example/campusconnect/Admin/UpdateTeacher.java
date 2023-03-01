package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.R;

public class UpdateTeacher extends AppCompatActivity {

    EditText tId, sal;
    AppCompatButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);
        tId=findViewById(R.id.teacherId);
        sal=findViewById(R.id.salary);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherId=tId.getText().toString();
                String salary=sal.getText().toString();
                if(!teacherId.isEmpty() && !salary.isEmpty()){
                    //REST API CONNECTION WORK(Retrofit)
                }
                else{
                    Toast.makeText(UpdateTeacher.this, "INSUFFICIENT DETAILS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}