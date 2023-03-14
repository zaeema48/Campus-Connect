package com.example.campusconnect.API;

import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AdminApiInterface {
    String Base_URL="http://campusaws-env.eba-2mb7eggz.ap-northeast-1.elasticbeanstalk.com/";

    @GET("admin_login")
    Call<String> adminLogin(
            @Query("adminId") String adminId,
            @Query("password") String password
    );

    @GET("get_batches")
    Call<List<BatchModel>> getBatch();

    @POST("add_batch")
    Call<Void> addBatch(
            @Body BatchModel batch
    );

    @GET("search_batch")
    Call<BatchModel> searchBatch(
        @Query("batchId") String batchId
    );

    @POST("add_student")
    Call<Void> addStudent(
            @Query("batchId") String batchId,
            @Body List<StudentModel> students
    );

    @DELETE("remove_student")
    Call<Void> removeStudent(
            @Query("studentId") int studentId
    );

    @GET("search_student")
    Call<List<StudentModel>> searchStudent(
            @Query("name") String name
    );

    @POST("add_teacher")
    Call<Void> addTeacher(
            @Body TeacherModel teacher
    );

    @DELETE("remove_teacher")
    Call<Void> removeTeacher(
            @Query("teacherId") int teacherId
    );

    @GET("search_teacher")
    Call<List<TeacherModel>> searchTeacher(
            @Query("name") String name
    );

    @GET("get_teacher")
    Call<List<TeacherModel>> teacherList();

    @PUT("update_salary")
    Call<Void> updateTeacher(
            @Query("teacherId") int teacherId,
            @Query("salary") String salary
    );

    @GET("fetch_subject_list")
    Call<List<SubjectModel>> subjectList();
}
