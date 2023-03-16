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
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        ProgressDialog progressDialog= new ProgressDialog(UpdateBatchSchedule.this);
        progressDialog.setTitle("Updating The Batch Schedule..");

        String [] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, days);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day= autoCompleteTextView.getText().toString();
                String batchId=enter_batch_id.getText().toString();

                if(!batchId.isEmpty() && !day.isEmpty()){
                    progressDialog.show();
                    ScheduleModel scheduleModel = new ScheduleModel();
                    scheduleModel.setDay(day);
                    scheduleModel.setSlot1(slot1.getText().toString());
                    scheduleModel.setSlot2(slot2.getText().toString());
                    scheduleModel.setSlot3(slot3.getText().toString());
                    scheduleModel.setSlot4(slot4.getText().toString());
                    scheduleModel.setSlot5(slot5.getText().toString());

                    ApiUtilities.getAdminApiInterface().updateBatchSchedule(batchId,scheduleModel).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateBatchSchedule.this, "Batch Schedule Updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateBatchSchedule.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateBatchSchedule.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                    Toast.makeText(UpdateBatchSchedule.this, "PLEASE FILL THE REQUIED DETAILS!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}