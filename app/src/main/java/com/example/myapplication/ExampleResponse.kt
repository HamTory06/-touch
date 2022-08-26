package com.example.myapplication

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.google.gson.annotations.SerializedName
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet

//ExampleResponse.kt
data class ExampleResponse (
    val id:Long,
    var counts:Long
    )
//public class PostResult {
//
//    @SerializedName("userId")
//    private val userId = 0
//
//    @SerializedName("id")
//    private val id = 0
//    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함
//
//    private val title: String? = null
//    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌
//
//    @SerializedName("body")
//    private val bodyValue: String? = null
//
//    // toString()을 Override 해주지 않으면 객체 주소값을 출력함
//    override fun toString(): String {
//        return "PostResult{" +
//                "userId=" + userId +
//                ", id=" + id +
//                ", title='" + title + '\'' +
//                ", bodyValue='" + bodyValue + '\'' +
//                '}'
//    }
//}
