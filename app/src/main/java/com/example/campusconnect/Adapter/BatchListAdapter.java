package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class BatchListAdapter extends RecyclerView.Adapter<BatchListAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView batchId, course,batchYear,duration,fees,currSemester;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            batchId=itemView.findViewById(R.id.batchId);
            course=itemView.findViewById(R.id.course);
            batchYear=itemView.findViewById(R.id.batchYear);
            duration=itemView.findViewById(R.id.duration);
            fees=itemView.findViewById(R.id.fees);
            currSemester=itemView.findViewById(R.id.currSemester);
        }
    }

    Context context;
    List<BatchModel> batches=new ArrayList<>();

    public BatchListAdapter(Context context, List<BatchModel> batches) {
        this.context = context;
        this.batches = batches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_batch_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.batchId.setText(batches.get(position).getBatchId());
        holder.course.setText(batches.get(position).getCourseName());
        holder.batchYear.setText(batches.get(position).getCourseYear());
        holder.duration.setText(batches.get(position).getCourseDuration());
        holder.fees.setText(batches.get(position).getFeesAmount());
        holder.currSemester.setText(batches.get(position).getCurrentSemester());
    }

    @Override
    public int getItemCount() {
        return batches.size();
    }


}
