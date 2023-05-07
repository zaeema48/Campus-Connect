package com.example.campusconnect.Adapter;


import static com.example.campusconnect.TeacherLogin.publicTeacher;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.MarkAttendanceModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;
import com.example.campusconnect.TeacherPage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarkAttendanceAdapter extends RecyclerView.Adapter<MarkAttendanceAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sid, name;
        RadioButton presentBtn, absentBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sid=itemView.findViewById(R.id.sid);
            name=itemView.findViewById(R.id.name);
            presentBtn=itemView.findViewById(R.id.present);
            absentBtn=itemView.findViewById(R.id.absent);
        }
    }

    Context context;
    List<MarkAttendanceModel> attendanceList= new ArrayList<>(); //datasource //it is to be sent to backend
    List<StudentModel> studentList = new ArrayList<>(); //datasource
    String date;
    String batchId;

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public MarkAttendanceAdapter(Context context, List<StudentModel> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mark_attendance_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sid.setText(""+studentList.get(position).getStudentId());
        holder.name.setText(studentList.get(position).getStudentName());

        MarkAttendanceModel markAttendance= new MarkAttendanceModel();
        markAttendance.setStudentId(studentList.get(position).getStudentId());
        AttendanceModel attendance= new AttendanceModel();
        attendance.setDate(date);

        holder.presentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attendance.setPresent("true");
                markAttendance.setAttendance(attendance);

                attendanceList.add(markAttendance);
            }
        });
        holder.absentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attendance.setPresent("false");
                markAttendance.setAttendance(attendance);

                attendanceList.add(markAttendance);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void uploadAttendance(){
        TeacherApi.getTeacherApiInterface().markAttendance(publicTeacher.getSubject().getSubjectId(),batchId, attendanceList).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Attendances Uploaded Successfully.", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(context, TeacherPage.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void allPresent(ViewHolder holder){

    }

}
