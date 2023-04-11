package com.example.campusconnect.Adapter;


import static com.example.campusconnect.TeacherLogin.publicTeacher;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Models.MarkAttendanceModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadMarksAdapter extends RecyclerView.Adapter<UploadMarksAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView student_id, student_name;
        EditText student_marks;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id=itemView.findViewById(R.id.sid);
            student_name=itemView.findViewById(R.id.sname);
            student_marks=itemView.findViewById(R.id.marks);

        }
    }
    Context context;
    List<StudentModel> studentList=new ArrayList<>();
    List<StudentProgressModel> studentProgressList=new ArrayList<>();   //to upload marks of each student //studentProgress is relation between student and subject

    public UploadMarksAdapter(Context context, List<StudentModel>studentList) {
        this.context=context;
        this.studentList=studentList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.marks_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.student_id.setText(""+studentList.get(position).getStudentId());
        holder.student_name.setText(studentList.get(position).getStudentName());

        StudentProgressModel studentProgress=new StudentProgressModel(); //making object of list since we can not directly add marks in list
        studentProgress.setProgressId(""+studentList.get(position).getStudentId()+publicTeacher.getSubject().getSubjectName());
        holder.student_marks.addTextChangedListener(new TextWatcher() {
            //ENTERED MARKS ARE BEING STORED HERE AND SEND
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                studentProgress.setMarks( Integer.parseInt(holder.student_marks.getText().toString()));
                studentProgressList.add(studentProgress);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public void saveStudentList(){
        TeacherApi.getTeacherApiInterface().uploadMarks(studentProgressList).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
