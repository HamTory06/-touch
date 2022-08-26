package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("1")
    fun getUser(): Call<ExampleResponse>

    @GET("pop/{page}")
    fun getUserPage(@Path("page") page: String): Call<ExampleResponse>

    @POST("http://43.200.182.132")
    open fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String?,
        @Field("body") text: String?
    ): Call<ExampleResponse>

}


//    @GET("pop/1")
//    suspend fun getPost(): Response<Long>
//
//
//    //POST 예제
//    @FormUrlEncoded
//    @POST("posts")
//    fun getContactsObject(@Field("idx") idx: String): Call<JsonObject>
