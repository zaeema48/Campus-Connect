package com.example.campusconnect.API;

import com.example.campusconnect.Models.AvailableSlot;
import com.example.campusconnect.Models.TeacherModel;

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

    @GET("empty_slot")
    Call<List<AvailableSlot>> availableSlot(
        @Query("teacherId") int teacherId,
        @Query("batchId") String batchId,
        @Query("day") String day
    );

}
