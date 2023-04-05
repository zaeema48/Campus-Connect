package com.example.campusconnect.Teacher;

import static com.example.campusconnect.TeacherLogin.publicTeacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Adapter.ViewBatchAttendanceAdapter;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBatchAttendance extends AppCompatActivity {
RecyclerView recyclerView;
EditText batchId;
AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_batch_attendance);
        recyclerView=findViewById(R.id.viewBatchRV);
        batchId=findViewById(R.id.batch);
        btn=findViewById(R.id.submit_button);

        ProgressDialog progressDialog = new ProgressDialog(ViewBatchAttendance.this);
        progressDialog.setTitle("Fetching Batch Attendance...");

        List<StudentModel> students= new ArrayList<>();
        List<StudentProgressModel> studentProgressList= new ArrayList<>();
        ViewBatchAttendanceAdapter adapter= new ViewBatchAttendanceAdapter(ViewBatchAttendance.this, students, studentProgressList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewBatchAttendance.this));
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bId=batchId.getText().toString();
                if(!bId.isEmpty()){
                    progressDialog.show();
                    TeacherApi.getTeacherApiInterface().BatchStudents(bId).enqueue(new Callback<List<StudentModel>>() {
                        @Override
                        public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                            students.clear();
                            students.addAll(response.body());
//                          GETTING BATCH ATTENDANCE
                            int sId=publicTeacher.getSubject().getSubjectId();
                            TeacherApi.getTeacherApiInterface().viewBatchAttendance(bId, sId).enqueue(new Callback<List<StudentProgressModel>>() {
                                @Override
                                public void onResponse(Call<List<StudentProgressModel>> call, Response<List<StudentProgressModel>> response) {
                                    studentProgressList.clear();
                                    studentProgressList.addAll(response.body());
                                    adapter.notifyDataSetChanged();
                                    progressDialog.dismiss();
                                }

                                @Override
                                public void onFailure(Call<List<StudentProgressModel>> call, Throwable t) {
                                    progressDialog.dismiss();
                                    Toast.makeText(ViewBatchAttendance.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }

                        @Override
                        public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(ViewBatchAttendance.this, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });

    }
}