package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class ViewBatchAttendanceAdapter extends RecyclerView.Adapter<ViewBatchAttendanceAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sid, name, attendance, classes, percentage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sid=itemView.findViewById(R.id.sId);
            name=itemView.findViewById(R.id.name);
            attendance=itemView.findViewById(R.id.attendance);
            classes=itemView.findViewById(R.id.classes);
            percentage=itemView.findViewById(R.id.percentage);
        }
    }

    Context context;
    List<StudentProgressModel> studentProgress= new ArrayList<>();
    List<StudentModel> students= new ArrayList<>();

    public ViewBatchAttendanceAdapter(Context context, List<StudentModel> students, List<StudentProgressModel> studentProgress) {
        this.context = context;
        this.students=students;
        this.studentProgress = studentProgress;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_batch_attendance_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sid.setText(""+students.get(position).getStudentId());
        holder.name.setText(students.get(position).getStudentName());
        holder.attendance.setText(""+studentProgress.get(position).getTotalAttendance());
        holder.classes.setText(""+studentProgress.get(position).getTotalClasses());
        holder.percentage.setText(""+studentProgress.get(position).getAttendancePercentage());
    }

    @Override
    public int getItemCount() {
        return studentProgress.size();
    }

}
