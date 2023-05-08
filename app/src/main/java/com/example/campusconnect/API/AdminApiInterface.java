package com.example.campusconnect.API;

import com.example.campusconnect.Models.AdminModel;
import com.example.campusconnect.Models.BatchModel;
import com.example.campusconnect.Models.ExamScheduleModel;
import com.example.campusconnect.Models.NoticeModel;
import com.example.campusconnect.Models.ScheduleModel;
import com.example.campusconnect.Models.StudentModel;
import com.example.campusconnect.Models.SubjectModel;
import com.example.campusconnect.Models.TeacherModel;
import com.example.campusconnect.Models.TeacherScheduleModel;

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
    String Base_URL="http://campus-connect-env.eba-mujcxbff.ap-south-1.elasticbeanstalk.com/admin/";

    @GET("admin_login")
    Call<AdminModel>  adminLogin(
            @Query("adminId") String adminId,
            @Query("password") String password
    );

    @PUT("admin_password")
    Call<Void> changePassword(
            @Query("adminId") String adminId,
            @Query("oldPassword") String oldPassword,
            @Query("newPassword") String newPassword
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

    @POST("add_exam_schedule")
    Call<Void>addExamSchedule(
            @Query("batchId") String batchId,
            @Body List<ExamScheduleModel> examSchedule
    );

    @GET("fetch_exam_schedule")
    Call<List<ExamScheduleModel>> getExamSchedule(
            @Query("batchId") String batchId
    );

    @PUT("/update_batch_schedule")
    Call<Void> updateBatchSchedule(
            @Query("batchId") String batchId,
            @Body ScheduleModel schedule
    );

    @PUT("update_fees_status")
    Call<Void> UpdateFeeStatus(
            @Query("studentId") int studentId,
            @Query("transactionId") String transactionId
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

    @PUT("update_teacher_schedule")
    Call<Void> updateTeacherSchedule(
            @Query("teacherId") int teacherId,
            @Body TeacherScheduleModel teacherSchedule
    );

    @PUT("update_batch_semester")
    Call<Void> updateBatchSemester(
            @Query("batchId") String batchId,
            @Query("currSem") String currSem,
            @Body List<ScheduleModel> schedules
    );

    @POST("add_notification")
    Call<Void> addNotice(
            @Body NoticeModel notification
    );

    @GET("all_notifications")
    Call<List<NoticeModel>> allNotices();

    @GET("search_notification")
    Call<List<NoticeModel>> searchNotice(
            @Query("title") String title
    );
}
