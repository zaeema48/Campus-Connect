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

public class SubjectAttendanceAdapter extends RecyclerView.Adapter<SubjectAttendanceAdapter.ViewHolder> {

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
    List<AttendanceModel> attendanceList= new ArrayList<>();

    public SubjectAttendanceAdapter(Context context, List<AttendanceModel> attendanceList) {
        this.attendanceList = attendanceList;
        this.context = context;
    }
    int subject_id;

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_attendance_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentId.setText(""+subject_id);
        holder.date.setText(attendanceList.get(position).getDate());
        holder.present.setText(attendanceList.get(position).getPresent());
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }


}
