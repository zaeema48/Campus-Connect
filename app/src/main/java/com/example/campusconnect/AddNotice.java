package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.Models.NoticeModel;

public class AddNotice extends AppCompatActivity {
    EditText title, noticeBody;
    CardView save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);
        title=findViewById(R.id.title);
        noticeBody=findViewById(R.id.notice);
        save=findViewById(R.id.save);

        NoticeModel notice= new NoticeModel();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty() && !noticeBody.getText().toString().isEmpty()){
                    notice.setNotificationTitle(title.getText().toString());
                    notice.setNotificationMessage(noticeBody.getText().toString());

//                    REST API WORKING
                }
                else
                    Toast.makeText(AddNotice.this, "PLEASE COMPLETE THE NOTICE!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}