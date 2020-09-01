package com.cybernerd.finalproject.network

import com.cybernerd.finalproject.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*


//const val BASE_URL = "http://192.168.43.57:8000"
const val BASE_URL = "https://cypherx404.herokuapp.com/"

interface CypherXAPI {
    companion object{
        operator fun invoke() : CypherXAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CypherXAPI::class.java)
        }
    }

    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("email")email: String,
        @Field("password")password: String
    ): Call<LoginResponse>

    @GET("classroom/manage/")
    fun getClassroom(
        @Header("Authorization") token : String): Call<ClassroomResponse>

    @GET("chat/conversation-list/")
    fun getConversationList(
        @Header("Authorization") token : String): Call<ConversationList>

    @GET("user/profile/")
    fun getProfile(
        @Header("Authorization") token : String): Call<Profile>

    @GET("miscellaneous/department-users/")
    fun getMember(
        @Header("Authroization") token: String) : Call<User>

    @GET("miscellaneous/all-students/")
    fun getAllStudent(
        @Header("Authorization") token: String) : Call<StudentResponse>

    @GET("staffroom/all-teachers")
    fun getAllTeachers(
        @Header("Authorization") token : String) : Call<StudentResponse>

    @FormUrlEncoded
    @POST("all-members/auto-complete/")
    fun getAutoComplete(
        @Header("Authorization") token : String,
        @Field("name") name : String) : Call<List<AutoCompleteResponse>>


    @FormUrlEncoded
    @POST("user/profile")
    fun editProfile(
        @Header("Authorization") token : String,
        @Field("id") id : Int,
        @Field("first_name") first_name : String,
        @Field("last_name") last_name : String,
        @Field("email") email : String,
        @Field("mobile") mobile : String,
        @Field("bio") bio : String,
        @Field("date") date : String

    ) : Call<EditProfile>


    @GET("classroom/my-classrooms/")
    fun getStudentClassroom(
        @Header("Authorization") token : String
    ) : Call<ClassroomResponse>

}