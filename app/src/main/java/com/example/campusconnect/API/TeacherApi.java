package com.example.campusconnect.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeacherApi {
    private static Retrofit retrofit=null;

    public static TeacherApiInterface getTeacherApiInterface(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(TeacherApiInterface.Base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(TeacherApiInterface.class);
    }
}
