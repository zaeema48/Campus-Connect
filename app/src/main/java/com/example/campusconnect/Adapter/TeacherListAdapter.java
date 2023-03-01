package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.R;

import java.util.ArrayList;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView teacherID, teacherName, salary, subject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teacherID=itemView.findViewById(R.id.teacherId);
            teacherName=itemView.findViewById(R.id.teacherName);
            salary=itemView.findViewById(R.id.salary);
            subject=itemView.findViewById(R.id.subject);
        }
    }

    Context context;
    ArrayList<TeacherModel> teachers= new ArrayList<>();

    public TeacherListAdapter(Context context, ArrayList<TeacherModel> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_teacher_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String id= String.valueOf(teachers.get(position).getTeacherId());
        holder.teacherID.setText(id);
        holder.teacherName.setText(teachers.get(position).getTeacherName());
        holder.salary.setText(teachers.get(position).getSalary());
        holder.subject.setText(teachers.get(position).getSubject().getSubjectName());
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

}
