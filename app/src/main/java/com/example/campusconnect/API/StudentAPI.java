package com.example.campusconnect.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentAPI {
    private static Retrofit retrofit=null;

    public static StudentApiInterface getStudentApiInterface(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(StudentApiInterface.Base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(StudentApiInterface.class);
    }
}
