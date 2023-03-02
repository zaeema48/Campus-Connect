package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectId, subjectName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectId=itemView.findViewById(R.id.subject_id);
            subjectName=itemView.findViewById(R.id.subject_name);
        }
    }

    Context context;
    ArrayList<SubjectModel> subjectList= new ArrayList<>();

    public SubjectListAdapter(Context context, ArrayList<SubjectModel> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_subject_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectListAdapter.ViewHolder holder, int position) {
       int id=Integer.valueOf(subjectList.get(position).getSubjectId());
        holder.subjectId.setText(id);
        holder.subjectName.setText(subjectList.get(position).getSubjectName());
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }


}
