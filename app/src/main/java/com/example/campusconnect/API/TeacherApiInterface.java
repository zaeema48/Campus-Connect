package com.example.campusconnect.API;

import com.example.campusconnect.Models.AvailableSlot;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.StudentProgressModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.Models.TeacherScheduleModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TeacherApiInterface {
    String Base_URL="http://Campusaws-env.eba-xya6pvty.ap-south-1.elasticbeanstalk.com/";

    @GET("teacher_login")
    Call<TeacherModel> teacherLogin(
            @Query("teacherId") int teacherId,
            @Query("password") String password
    );

    @GET("teacher_schedule")
    Call<List<TeacherScheduleModel>> scheduleModel(
            @Query("teacherId") int teacherId
    );

    @GET("empty_slot")
    Call<List<AvailableSlot>> availableSlot(
        @Query("teacherId") int teacherId,
        @Query("batchId") String batchId,
        @Query("day") String day

    );

    @GET("batch_students")
    Call<List<StudentModel>> BatchStudents(
            @Query("batchId") String batchId
    );

    @POST("upload_marks")
    Call<Void>uploadMarks(
            @Body List<StudentProgressModel> studentsProgress
    );

    @GET("view_batch_attendance")
    Call<List<StudentProgressModel>> viewBatchAttendance(
            @Query ("batchId") String batchId,
            @Query ("subjectId")int subjectId
    );

}
