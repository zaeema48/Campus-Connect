package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentId, date, present;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentId=itemView.findViewById(R.id.sId);
            date=itemView.findViewById(R.id.date);
            present=itemView.findViewById(R.id.present);
        }
    }

    Context context;
    List<AttendanceModel> attendances= new ArrayList<>();
    int sID;

    public StudentAttendanceAdapter(Context context, List<AttendanceModel> attendances, int sId) {
        this.context = context;
        this.attendances = attendances;
        this.sID=sId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.student_attendance_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentId.setText(sID);
        holder.date.setText(attendances.get(position).getDate());
        holder.present.setText(attendances.get(position).getPresent());
    }

    @Override
    public int getItemCount() {
        return attendances.size();
    }


}
