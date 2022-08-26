package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        val back = findViewById<ConstraintLayout>(R.id.back)
        val retrofit = Retrofit.Builder().baseUrl("http://43.200.182.132")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitService::class.java)

        service.getUserPage("1").enqueue(object : Callback<ExampleResponse>{
            override fun onResponse(call: Call<ExampleResponse>, response: Response<ExampleResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    var result: ExampleResponse? = response.body()
                    Log.d("YMC", "onResponse 성공: " + result?.toString())
                    back.setOnClickListener(){
                        tv.setText("${result!!.id}")
                        //result.createPost()
                    }
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<ExampleResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString())
            }
        })
    }
}