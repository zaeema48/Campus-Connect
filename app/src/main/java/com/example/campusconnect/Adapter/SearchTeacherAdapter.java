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
import java.util.List;

public class SearchTeacherAdapter extends RecyclerView.Adapter<SearchTeacherAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView teacherId, teacherName, teacherPasw, salary, teacherEmail, subject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teacherId=itemView.findViewById(R.id.teacherId);
            teacherName=itemView.findViewById(R.id.teacherName);
            teacherPasw=itemView.findViewById(R.id.teacherPasw);
            salary=itemView.findViewById(R.id.salary);
            teacherEmail=itemView.findViewById(R.id.teacherEmail);
            subject=itemView.findViewById(R.id.subject);
        }
    }
    Context context;
    List<TeacherModel> teachers= new ArrayList<>();

    public SearchTeacherAdapter(Context context, List<TeacherModel> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_search_teacher,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.teacherId.setText("Teacher ID \n"+teachers.get(position).getTeacherId());
        holder.teacherName.setText("Teacher Name \n"+teachers.get(position).getTeacherName());
        holder.teacherPasw.setText("Password \n"+teachers.get(position).getTeacherPassword());
        holder.salary.setText("Salary \n"+teachers.get(position).getSalary());
        holder.teacherEmail.setText("Teacher Email \n"+teachers.get(position).getTeacherEmail());
        holder.subject.setText("Subject \n"+teachers.get(position).getSubject().getSubjectName());
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

}
