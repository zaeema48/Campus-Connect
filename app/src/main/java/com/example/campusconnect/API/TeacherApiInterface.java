package com.example.campusconnect.API;

import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.Models.TeacherScheduleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
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

}
