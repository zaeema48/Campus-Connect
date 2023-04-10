package com.example.campusconnect.API;

import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.Teacher.ViewSchedule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudentApiInterface {
    String Base_URL="http://campusaws-env.eba-xya6pvty.ap-south-1.elasticbeanstalk.com/student/";

    @GET("student_login")
    public Call<StudentModel> studentLogin(
      @Query("studentId") int studentId,
      @Query ("password") String password
    );

    @GET("class_schedules")
    public Call<List<ScheduleModel>> viewCLassSchedule(
            @Query("studentId") int studentId
    );

    @GET("notification")
    public Call<List<NoticeModel>> getNotices();

    @GET("search_notification")
    public Call<List<NoticeModel>> searchNotices(
            @Query("title") String title
    );

    @GET("student_progress")
    public Call<List<StudentProgressModel>> viewMarks(
        @Query("studentId") int studentId
    );

    @GET("view_subject_attendance")
    public Call<List<AttendanceModel>> viewSubjectAttendance(
           @Query("studentId") int studentId,
           @Query("subjectId") int subjectId
    );

}
