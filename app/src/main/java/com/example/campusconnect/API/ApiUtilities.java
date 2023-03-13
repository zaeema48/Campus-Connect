package com.example.campusconnect.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static Retrofit retrofit=null;

    public static AdminApiInterface getAdminApiInterface(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(AdminApiInterface.Base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(AdminApiInterface.class);
    }
}
