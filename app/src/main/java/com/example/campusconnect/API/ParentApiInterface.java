package com.example.campusconnect.API;

import com.example.campusconnect.Models.AttendanceModel;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.Models.ParentModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.StudentProgressModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ParentApiInterface {
    String Base_URL = "http://campus-connect-env.eba-mujcxbff.ap-south-1.elasticbeanstalk.com/parent/";

    @POST("parent_signup")
    Call<Void> parentSignup(
            @Query("studentId") int studentId,
            @Body ParentModel parent
    );
    @GET("parent_login")
    Call<ParentModel> parentLogin(
            @Query("parentId") int parentId,
            @Query("password") String password
    );
    @PUT("change_password")
    Call<Void> passwordChange(
            @Query("parentId") int parentId,
            @Query("newPassword") String newPassword
    );
    @GET("class_schedules")
    Call<List<ScheduleModel>> classSchedule(
            @Query("studentId") int studentId
    );
    @GET("student_progress")
    Call<List<StudentProgressModel>> semesterProgress(
                @Query("studentId") int studentId,
                @Query("semester") String semester
    );
    @GET("view_subject_attendance")
    Call<List<AttendanceModel>> getAttendance(
            @Query("studentId") int studentId,
            @Query("subjectId") int subjectId
    );

    @GET("fetch_exam_schedule")
    Call<List<ExamScheduleModel>> fetchExamSchedule(
            @Query("studentId") int studentId
    );

}
