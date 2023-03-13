package com.example.campusconnect.API;

import com.example.campusconnect.Models.BatchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AdminApiInterface {
    String Base_URL="http://campusaws-env.eba-xya6pvty.ap-south-1.elasticbeanstalk.com/";

    @GET("get_batches")
    Call<List<BatchModel>> getBatch();

    @POST("add_batch")
    Call<BatchModel> addBatch(
            @Body BatchModel batch
    );
    @GET("search_batch")
    Call<BatchModel> searchBatch(
        @Query("batchId") String batchId
    );
}
