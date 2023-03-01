package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.AdminPage;
import com.example.campusconnect.Fragments.HomeFragment;
import com.example.campusconnect.MainActivity;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class AddStudent extends AppCompatActivity {
    EditText student_name, student_email, parent_email, batch_id;
    Button save_and_exit, save_and_add_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        student_name = findViewById(R.id.student_name);
        student_email = findViewById(R.id.student_email);
        parent_email = findViewById(R.id.parent_email);
        batch_id=findViewById(R.id.batch_id);
        save_and_exit=findViewById(R.id.save_and_exit);
        save_and_add_more=findViewById(R.id.save_and_add_more);

        StudentModel studentModel=new StudentModel();

        ArrayList<StudentModel> students = new ArrayList<>();

        save_and_add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName=student_name.getText().toString();
                String studentEmail=student_email.getText().toString();
                String parentsEmail=parent_email.getText().toString();
                String batchId=batch_id.getText().toString();

                if(!studentName.isEmpty() && !studentEmail.isEmpty() && !parentsEmail.isEmpty() && !batchId.isEmpty() ){
                        studentModel.setStudentName(studentName);
                        studentModel.setStudentEmail(studentEmail);
                        studentModel.setParentEmail(parentsEmail);

                        students.add(studentModel);

                        student_name.setText("");
                        student_email.setText("");
                        parent_email.setText("");
                        batch_id.setText("");

                }
                else
                    Toast.makeText(AddStudent.this, "Fill the required details!", Toast.LENGTH_SHORT).show();

            }
        });

        save_and_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName=student_name.getText().toString();
                String studentEmail=student_email.getText().toString();
                String parentsEmail=parent_email.getText().toString();
                String batchId=batch_id.getText().toString();

                if(!studentName.isEmpty() && !studentEmail.isEmpty() && !parentsEmail.isEmpty() && !batchId.isEmpty() ){
                    studentModel.setStudentName(studentName);
                    studentModel.setStudentEmail(studentEmail);
                    studentModel.setParentEmail(parentsEmail);
                    students.add(studentModel);

                    Intent intent = new Intent(AddStudent.this, AdminPage.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(AddStudent.this, "Fill the required details!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
