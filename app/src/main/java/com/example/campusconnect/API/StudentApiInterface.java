package com.example.campusconnect.API;

import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface StudentApiInterface {
    String Base_URL="http://campus-connect-env.eba-mujcxbff.ap-south-1.elasticbeanstalk.com/student/";

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
    public Call<List<StudentProgressModel>> semesterProgress(
        @Query("studentId") int studentId,
        @Query("semester") String semester
    );
    
    @PUT("change_password")
    public Call<Void> passwordChange(
            @Query("studentId") int studentId,
            @Query("newPassword") String newPassword
    );

    @GET("view_subject_attendance")
    public Call<List<AttendanceModel>> viewSubjectAttendance(
           @Query("studentId") int studentId,
           @Query("subjectId") int subjectId
    );

    @GET("fetch_exam_schedule")
    public Call<List<ExamScheduleModel>> fetchExamSchedule(
            @Query("studentId") int studentId
    );

}
