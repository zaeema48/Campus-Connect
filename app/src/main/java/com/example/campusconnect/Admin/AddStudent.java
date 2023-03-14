package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.AdminPage;
import com.example.campusconnect.Fragments.HomeFragment;
import com.example.campusconnect.MainActivity;
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        ProgressDialog progressDialog = new ProgressDialog(AddStudent.this);
        progressDialog.setTitle("Storing Students Detail..");

        ArrayList<StudentModel> students = new ArrayList<>();

        save_and_add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName=student_name.getText().toString();
                String studentEmail=student_email.getText().toString();
                String parentsEmail=parent_email.getText().toString();
                String batchId=batch_id.getText().toString();

                if(!studentName.isEmpty() && !studentEmail.isEmpty() && !parentsEmail.isEmpty() && !batchId.isEmpty() ){
                    StudentModel studentModel=new StudentModel();
                        studentModel.setStudentName(studentName);
                        studentModel.setStudentEmail(studentEmail);
                        studentModel.setParentEmail(parentsEmail);

                        students.add(studentModel);

                        student_name.setText("");
                        student_email.setText("");
                        parent_email.setText("");

                }
                else
                    Toast.makeText(AddStudent.this, "Fill the required details!", Toast.LENGTH_SHORT).show();

            }
        });

        save_and_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String studentName=student_name.getText().toString();
                String studentEmail=student_email.getText().toString();
                String parentsEmail=parent_email.getText().toString();
                String batchId=batch_id.getText().toString();

                if(!studentName.isEmpty() && !studentEmail.isEmpty() && !parentsEmail.isEmpty() && !batchId.isEmpty() ){
                    StudentModel studentModel=new StudentModel();
                    studentModel.setStudentName(studentName);
                    studentModel.setStudentEmail(studentEmail);
                    studentModel.setParentEmail(parentsEmail);

                    students.add(studentModel);

                    ApiUtilities.getAdminApiInterface().addStudent(batchId,students).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(AddStudent.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddStudent.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(AddStudent.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                    Toast.makeText(AddStudent.this, "Fill the required details!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
