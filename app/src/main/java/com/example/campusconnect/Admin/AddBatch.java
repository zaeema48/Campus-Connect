package com.example.campusconnect.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.campusconnect.R;

public class AddBatch extends AppCompatActivity {


    EditText year, feesAmount;
    CardView button;
    String[] courseName = {"B.Tech CSE", "B.Tech ECE", "B.Tech AI", "B.Sc.", "MBBS", "LLB"};
    String[] duration = {"4 yrs", "3 yrs", "5 yrs", "5yrs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, courseName);

        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.course);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, duration);
        AutoCompleteTextView acTextView2 = (AutoCompleteTextView) findViewById(R.id.duration);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter2);

        //the entered data will be stored at the backend
//        year = findViewById(R.id.year);
//        feesAmount = findViewById(R.id.fees);
//        button = findViewById(R.id.addbatchbutton);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String yr = year.getText().toString();
//                String fees = feesAmount.getText().toString();
//
//
//                //
//            }
//        });


    }
}