package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class UpdateBatchSchedule extends AppCompatActivity {
Button updateBtn;
EditText enter_batch_id, slot1, slot2, slot3, slot4, slot5;
AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_batch_schedule);

        updateBtn=findViewById(R.id.updateBtn);
        autoCompleteTextView=findViewById(R.id.day);
        enter_batch_id=findViewById(R.id.enter_batch_id);
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

        ScheduleModel scheduleModel = new ScheduleModel();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batchId=enter_batch_id.getText().toString(); //fetching the views
                if(!batchId.isEmpty()){

                    autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            String slot_1=slot1.getText().toString();
                            String slot_2=slot2.getText().toString();
                            String slot_3=slot3.getText().toString();
                            String slot_4=slot4.getText().toString();
                            String slot_5=slot5.getText().toString();

                            scheduleModel.setSlot1(slot_1);
                            scheduleModel.setSlot2(slot_2);
                            scheduleModel.setSlot3(slot_3);
                            scheduleModel.setSlot4(slot_4);
                            scheduleModel.setSlot5(slot_5);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
            }
        });
    }
}