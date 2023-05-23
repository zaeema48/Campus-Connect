package com.example.campusconnect.Adapter;


import static com.example.campusconnect.TeacherLogin.publicTeacher;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusconnect.API.TeacherApi;
import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.MarkAttendanceModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.R;
import com.example.campusconnect.TeacherPage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarkAttendanceAdapter extends RecyclerView.Adapter<MarkAttendanceAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView sid, name;
        CheckBox presentBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sid=itemView.findViewById(R.id.sid);
            name=itemView.findViewById(R.id.name);
            presentBtn=itemView.findViewById(R.id.presentBtn);
        }
    }

    Context context;
    List<MarkAttendanceModel> attendanceList= new ArrayList<>(); //datasource //it is to be sent to backend
    List<StudentModel> studentList = new ArrayList<>(); //datasource
    String date;
    String batchId;

    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public MarkAttendanceAdapter(Context context, List<StudentModel> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mark_attendance_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sid.setText(""+studentList.get(position).getStudentId());
        holder.name.setText(studentList.get(position).getStudentName());
        checkBoxes.add(holder.presentBtn);

        MarkAttendanceModel markAttendance= new MarkAttendanceModel();
        markAttendance.setStudentId(studentList.get(position).getStudentId());
        AttendanceModel attendance= new AttendanceModel();
        attendance.setDate(date);
        attendance.setPresent("false");

        markAttendance.setAttendance(attendance);
        attendanceList.add(markAttendance);

        holder.presentBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    attendance.setPresent("true");

                    markAttendance.setAttendance(attendance);
                    attendanceList.add(markAttendance);
                }
                else {

                    attendance.setPresent("false");

                    markAttendance.setAttendance(attendance);
                    attendanceList.add(markAttendance);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public void uploadAttendance(){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Uploading Attendance...");
        progressDialog.show();
        TeacherApi.getTeacherApiInterface().markAttendance(publicTeacher.getSubject().getSubjectId(),batchId, attendanceList).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDialog.dismiss();
                Toast.makeText(context, "Attendances Uploaded Successfully.", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(context, TeacherPage.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(context, "An Error Has Occurred!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void allPresent(){
        for(int i=0;i<checkBoxes.size();i++){
            CheckBox checkBox=checkBoxes.get(i);
            checkBox.setChecked(true);
            attendanceList.get(i).getAttendance().setPresent("true");
        }
    }
    public void allAbsent(){
        for(int i=0;i<checkBoxes.size();i++){
            CheckBox checkBox=checkBoxes.get(i);
            checkBox.setChecked(false);
            attendanceList.get(i).getAttendance().setPresent("false");
        }
    }

}
