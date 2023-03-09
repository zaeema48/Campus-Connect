package com.example.campusconnect.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentId, studentName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentId=itemView.findViewById(R.id.studentId);
            studentName=itemView.findViewById(R.id.studentName);
        }
    }

    Context context;
    List<StudentModel> students=new ArrayList<>();

    public StudentListAdapter(Context context, List<StudentModel> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_student_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String sId=String.valueOf(students.get(position).getStudentId()); --ALTERNATIVE
        holder.studentId.setText(""+students.get(position).getStudentId()); //USING STRING CONCATENATION
        holder.studentName.setText(students.get(position).getStudentName());

    }

    @Override
    public int getItemCount() {
        return students.size();
    }


}
