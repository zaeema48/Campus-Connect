package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.TeacherScheduleModel;
import com.example.campusconnect.R;

public class UpdateTeacherSchedule extends AppCompatActivity {
    Button updateBtn;
    EditText teacher_id, slot1, slot2, slot3, slot4, slot5;
    AutoCompleteTextView autoCompleteTextView;
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

        String [] day= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, day);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        TeacherScheduleModel teacherSchedule = new TeacherScheduleModel();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherId=teacher_id.getText().toString(); //fetching the views
                if(!teacherId.isEmpty()){

                    autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


//                            scheduleModel.setDay();  ???
                            teacherSchedule.setSlot1(slot1.getText().toString());
                            teacherSchedule.setSlot2(slot2.getText().toString());
                            teacherSchedule.setSlot3(slot3.getText().toString());
                            teacherSchedule.setSlot4(slot4.getText().toString());
                            teacherSchedule.setSlot5(slot5.getText().toString());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else
                    Toast.makeText(UpdateTeacherSchedule.this, "PLEASE FILL THE REQUIED DETAILS!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}