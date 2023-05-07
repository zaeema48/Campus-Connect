package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class SearchExamScheduleAdapter extends RecyclerView.Adapter<SearchExamScheduleAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject, date, time, room;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.subject);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);
            room=itemView.findViewById(R.id.room);
        }
    }

    Context context;
    List<ExamScheduleModel> examSchedule= new ArrayList<>();

    public SearchExamScheduleAdapter(Context context, List<ExamScheduleModel> examSchedule) {
        this.context = context;
        this.examSchedule = examSchedule;
        if(examSchedule.isEmpty())
            Toast.makeText(context, "Exam Schedule has not yet Uploaded!!", Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_view_exam,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(examSchedule.size()==0)
            Toast.makeText(context, "Exam Schedule has not yet Uploaded!!", Toast.LENGTH_SHORT).show();
       holder.subject.setText(examSchedule.get(position).getSubject());
       holder.date.setText( examSchedule.get(position).getDate());
       holder.time.setText(examSchedule.get(position).getTime());
       holder.room.setText(examSchedule.get(position).getRoomAllocated());
    }

    @Override
    public int getItemCount() {
        return examSchedule.size();
    }


}
