package com.example.campusconnect.API;

import com.example.campusconnect.Models.ParentModel;

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
}
