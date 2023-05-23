package com.example.campusconnect.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeacherApi {
    private static Retrofit retrofit=null;

    public static TeacherApiInterface getTeacherApiInterface(){

        if(retrofit==null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .callTimeout(4,TimeUnit.MINUTES)
                    .connectTimeout(4, TimeUnit.MINUTES)
                    .readTimeout(4, TimeUnit.MINUTES)
                    .writeTimeout(4, TimeUnit.MINUTES)
                    .build();
            retrofit = new Retrofit.Builder().baseUrl(TeacherApiInterface.Base_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(TeacherApiInterface.class);
    }
}
