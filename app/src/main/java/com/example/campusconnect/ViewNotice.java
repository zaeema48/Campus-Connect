package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewNotice extends AppCompatActivity {
    TextView title, notice, author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notice);
        title=findViewById(R.id.title);
        notice=findViewById(R.id.notice);
        author=findViewById(R.id.author);

        String heading=getIntent().getStringExtra("title");
        String message=getIntent().getStringExtra("message");
        String auth=getIntent().getStringExtra("author");

        title.setText(heading);
        notice.setText(message);
        author.setText(auth);
    }
}