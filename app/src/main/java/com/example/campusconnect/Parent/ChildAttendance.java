package com.example.campusconnect.Parent;

import static com.example.campusconnect.ParentLogin.publicParent;
import static com.example.campusconnect.StudentLogin.publicStudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.ParentAPI;
import com.example.campusconnect.API.StudentAPI;
import com.example.campusconnect.Adapter.SubjectAttendanceAdapter;
import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.R;
import com.example.campusconnect.Student.ViewAttendance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildAttendance extends AppCompatActivity {

    EditText subjectId;
    Button submit;
    RecyclerView recyclerView;
    int sId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_attendance);

        subjectId=findViewById(R.id.subjectId);
        submit=findViewById(R.id.submit);
        recyclerView=findViewById(R.id.viewStudentRV);

        ProgressDialog progressDialog= new ProgressDialog(ChildAttendance.this);
        progressDialog.setTitle("Fetching Attendance...");

        List<AttendanceModel> attendanceList= new ArrayList<>();
        SubjectAttendanceAdapter adapter= new SubjectAttendanceAdapter(ChildAttendance.this, attendanceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChildAttendance.this));
        recyclerView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject_id=subjectId.getText().toString();
                if(!subject_id.isEmpty()){
                    progressDialog.show();

                    ParentAPI.getParentApiInterface().getAttendance(publicParent.getStudentId(), Integer.parseInt(subject_id)).enqueue(new Callback<List<AttendanceModel>>() {
                        @Override
                        public void onResponse(Call<List<AttendanceModel>> call, Response<List<AttendanceModel>> response) {
                            attendanceList.clear();
                            attendanceList.addAll(response.body());
                            adapter.setSubject_id(Integer.parseInt(subject_id));
                            adapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<List<AttendanceModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(ChildAttendance.this, "ERROR!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ChildAttendance.this, "Enter Subject Id!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}