package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.MarkAttendanceModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;


public class MarkAttendanceAdapter extends RecyclerView.Adapter<MarkAttendanceAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sid, name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sid=itemView.findViewById(R.id.sid);
            name=itemView.findViewById(R.id.name);
        }
    }

    Context context;
    List<MarkAttendanceModel> attendanceList= new ArrayList<>(); //datasource //it is to be sent to backend
    List<StudentModel> studentList = new ArrayList<>(); //datasource
    private String date;

    public String getDate() {
        return date;
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
        Toast.makeText(context, ""+date, Toast.LENGTH_SHORT).show();
        holder.sid.setText(""+studentList.get(position).getStudentId());
        holder.name.setText(studentList.get(position).getStudentName());
        MarkAttendanceModel markAttendance= new MarkAttendanceModel();
        markAttendance.setStudentId(studentList.get(position).getStudentId());
        AttendanceModel attendance= new AttendanceModel();
        attendance.setDate(date);
//        attendance.setPresent();
        markAttendance.setAttendance(attendance);

        attendanceList.add(markAttendance);


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

}
