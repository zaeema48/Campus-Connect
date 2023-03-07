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

public class SearchStudentAdapter extends RecyclerView.Adapter<SearchStudentAdapter.ViewHolder> {

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentId, studentName, studentPasw, fees, studentEmail, parentEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentId=itemView.findViewById(R.id.studentId);
            studentName=itemView.findViewById(R.id.studentName);
            studentPasw=itemView.findViewById(R.id.studentPasw);
            fees=itemView.findViewById(R.id.feeStatus);
            studentEmail=itemView.findViewById(R.id.studentEmail);
            parentEmail=itemView.findViewById(R.id.parentEmail);
        }
    }

    Context context;
    ArrayList<StudentModel> students;

    public SearchStudentAdapter(Context context, ArrayList<StudentModel> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_search_student,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentId.setText("Student ID \n"+students.get(position).getStudentId());
        holder.studentName.setText("Student Name \n"+students.get(position).getStudentName());
        holder.studentPasw.setText("Password \n"+students.get(position).getPassword());
        if(students.get(position).getFeesPaid())
            holder.fees.setText("Fee Status \nPaid, "+students.get(position).getTransactionId());
        else
            holder.fees.setText("Fee Status \nNot Paid");
        holder.studentEmail.setText("Student Email \n"+students.get(position).getStudentEmail());
        holder.parentEmail.setText("Parent Email \n"+students.get(position).getParentEmail());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


}
