package com.example.myapplication

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val back = findViewById<ConstraintLayout>(R.id.back)
        val tv = findViewById<TextView>(R.id.tv)
        val settings = getSharedPreferences("name", MODE_PRIVATE)
        var num : Long = settings.getLong("number", 0) // 1번째 인자에서는 저장할 당시의 키 값을 적어줌, 2번째는 키 값에 데이터가 존재하지 않을 경우 대체
        tv.setText("${num}")
        val editor: Editor = settings.edit() // 수정모드
        back.setOnClickListener {
            num++
            tv.setText("${num}")
            //Log.d("tag","num:"+num) //Logcat에 num값출력
            editor.putLong("number", num) // 1번째 인자에는 키 값을, 2번째 인자에는 실제 담아들 값
            editor.apply() //값을 저장 완료
        }

    }

    /*private fun loadData(){
        val pref = getSharedPreferences("pref",MODE_PRIVATE)
        pref.getLong("name",0)

    private fun saveData(){
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        val edit = pref.edit()
        edit.putLong("name",num)
        edit.apply()
    }*/
}
