package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

public class AddBatch extends AppCompatActivity {


    EditText year, feesAmount;
    EditText m1,  m2, m3, m4, m5, t1, t2, t3, t4, t5, w1, w2, w3, w4, w5, th1, th2, th3, th4, th5, f1, f2, f3, f4, f5;
    Button save;
    String courseName,duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);
        fetchView();

        String[] courseNames = {"B.TechCSE", "B.TechECE", "B.TechAI","BCA", "B.Sc.", "MBBS", "LLB"};
        String[] durations = {"3 yrs", "4 yrs",  "5 yrs"};
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.course);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, courseNames);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        AutoCompleteTextView acTextView2 = (AutoCompleteTextView) findViewById(R.id.duration);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, durations);
        acTextView2.setThreshold(1);
        acTextView2.setAdapter(adapter2);

        ProgressDialog progressDialog=new ProgressDialog(AddBatch.this);
        progressDialog.setTitle("Saving New Batch..");

        BatchModel batchModel = new BatchModel();

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String yr = year.getText().toString();
                String fees = feesAmount.getText().toString();
                courseName=acTextView.getText().toString();
                duration=acTextView2.getText().toString();
                if(!yr.isEmpty() && !fees.isEmpty() && !courseName.isEmpty() && !duration.isEmpty()){
                    progressDialog.show();
                    batchModel.setCourseName(courseName);
                    batchModel.setCourseDuration(duration);
                    batchModel.setCourseYear(yr);
                    batchModel.setFeesAmount(fees);

//                    ADDING SCHEDULES
                    ArrayList<ScheduleModel> schedules = new ArrayList<>();
                    ScheduleModel schedule1= new ScheduleModel();
                    schedule1.setDay("Monday");
                    schedule1.setSlot1(m1.getText().toString());
                    schedule1.setSlot2(m2.getText().toString());
                    schedule1.setSlot3(m3.getText().toString());
                    schedule1.setSlot4(m4.getText().toString());
                    schedule1.setSlot5(m5.getText().toString());
                    schedules.add(schedule1);

                    ScheduleModel schedule2= new ScheduleModel();
                    schedule2.setDay("Tuesday");
                    schedule2.setSlot1(t1.getText().toString());
                    schedule2.setSlot2(t2.getText().toString());
                    schedule2.setSlot3(t3.getText().toString());
                    schedule2.setSlot4(t4.getText().toString());
                    schedule2.setSlot5(t5.getText().toString());
                    schedules.add(schedule2);

                    ScheduleModel schedule3= new ScheduleModel();
                    schedule3.setDay("Wednesday");
                    schedule3.setSlot1(w1.getText().toString());
                    schedule3.setSlot2(w2.getText().toString());
                    schedule3.setSlot3(w3.getText().toString());
                    schedule3.setSlot4(w4.getText().toString());
                    schedule3.setSlot5(w5.getText().toString());
                    schedules.add(schedule3);

                    ScheduleModel schedule4= new ScheduleModel();
                    schedule4.setDay("Thursday");
                    schedule4.setSlot1(th1.getText().toString());
                    schedule4.setSlot2(th2.getText().toString());
                    schedule4.setSlot3(th3.getText().toString());
                    schedule4.setSlot4(th4.getText().toString());
                    schedule4.setSlot5(th5.getText().toString());
                    schedules.add(schedule4);

                    ScheduleModel schedule5= new ScheduleModel();
                    schedule5.setDay("Friday");
                    schedule5.setSlot1(f1.getText().toString());
                    schedule5.setSlot2(f2.getText().toString());
                    schedule5.setSlot3(f3.getText().toString());
                    schedule5.setSlot4(f4.getText().toString());
                    schedule5.setSlot5(f5.getText().toString());
                    schedules.add(schedule5);
//              ADDING ALL THE SCHEDULES INTO THE BATCH MODEL
                    batchModel.setSchedules(schedules);

                    ApiUtilities.getAdminApiInterface().addBatch(batchModel).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            progressDialog.dismiss();
                            Toast.makeText(AddBatch.this, "SUCCESSFULLY SAVED", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(AddBatch.this, AdminPage.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(AddBatch.this, "AN ERROR HAS OCCURRED DURING SAVING!! ", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                    Toast.makeText(AddBatch.this, "PLease fill the Required Details!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void fetchView(){
        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        w1=findViewById(R.id.w1);
        w2=findViewById(R.id.w2);
        w3=findViewById(R.id.w3);
        w4=findViewById(R.id.w4);
        w5=findViewById(R.id.w5);
        th1=findViewById(R.id.th1);
        th2=findViewById(R.id.th2);
        th3=findViewById(R.id.th3);
        th4=findViewById(R.id.th4);
        th5=findViewById(R.id.th5);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        year=findViewById(R.id.year);
        feesAmount=findViewById(R.id.fees);
        save=findViewById(R.id.save);
    }
}