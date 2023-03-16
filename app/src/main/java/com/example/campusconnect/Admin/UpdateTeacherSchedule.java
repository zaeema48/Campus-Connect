package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ApiUtilities;
import com.example.campusconnect.AdminPage;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.TeacherScheduleModel;
import com.example.campusconnect.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateTeacherSchedule extends AppCompatActivity {
    Button updateBtn;
    EditText teacher_id, slot1, slot2, slot3, slot4, slot5;
    AutoCompleteTextView autoCompleteTextView;
    String day=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher_schedule);
        updateBtn=findViewById(R.id.updateBtn);
        autoCompleteTextView=findViewById(R.id.day);
        teacher_id=findViewById(R.id.teacher_id);
        slot1=findViewById(R.id.slot1);
        slot2=findViewById(R.id.slot2);
        slot3=findViewById(R.id.slot3);
        slot4=findViewById(R.id.slot4);
        slot5=findViewById(R.id.slot5);

        ProgressDialog progressDialog = new ProgressDialog(UpdateTeacherSchedule.this);
        progressDialog.setTitle("Updating Teacher Schedule..");

        String [] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, days);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherId=teacher_id.getText().toString(); //fetching the views
                String day=autoCompleteTextView.getText().toString();
                if(!teacherId.isEmpty() && !day.isEmpty()){
                    progressDialog.show();
                    int teacherID=Integer.parseInt(teacherId);
                    TeacherScheduleModel teacherSchedule = new TeacherScheduleModel();
                    teacherSchedule.setDay(day);
                    teacherSchedule.setSlot1(slot1.getText().toString());
                    teacherSchedule.setSlot2(slot2.getText().toString());
                    teacherSchedule.setSlot3(slot3.getText().toString());
                    teacherSchedule.setSlot4(slot4.getText().toString());
                    teacherSchedule.setSlot5(slot5.getText().toString());

                    ApiUtilities.getAdminApiInterface().updateTeacherSchedule(teacherID,teacherSchedule).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateTeacherSchedule.this, "Teacher Schedule Updated Successfully.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(UpdateTeacherSchedule.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateTeacherSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                    Toast.makeText(UpdateTeacherSchedule.this, "PLEASE FILL THE REQUIRED DETAILS!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}