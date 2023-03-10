package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

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
    ArrayList<ExamScheduleModel> examSchedule;

    public SearchExamScheduleAdapter(Context context, ArrayList<ExamScheduleModel> examSchedule) {
        this.context = context;
        this.examSchedule = examSchedule;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_view_exam,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.subject.setText("Subject \n" + examSchedule.get(position).getSubject());
       holder.date.setText("Date \n" + examSchedule.get(position).getDate());
       holder.time.setText("Time \n" + examSchedule.get(position).getTime());
       holder.room.setText("Room no \n" + examSchedule.get(position).getRoomAllocated());
    }

    @Override
    public int getItemCount() {
        return examSchedule.size();
    }


}
