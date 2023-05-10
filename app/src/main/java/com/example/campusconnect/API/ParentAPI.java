package com.example.campusconnect.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParentAPI {
    private static Retrofit retrofit=null;

    public static ParentApiInterface getParentApiInterface(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(ParentApiInterface.Base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ParentApiInterface.class);
    }
}
