package com.example.activitytest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private var hasSetResult = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val putExtra_Key = intent.getStringExtra("putExtra_Key")
        Log.d("SecondActivity" , "putExtra_Key = $putExtra_Key")
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener({
            val intent = Intent()
            intent.putExtra("return_value" , "返回值")
            setResult(RESULT_OK , intent)
            hasSetResult = true
            finish()
        })
    }
//    override fun onBackPressed() {
//        val intent = Intent()
//        intent.putExtra("return_value" , "用户直接使用返回键")
//        setResult(RESULT_OK , intent)
//        finish()
//    }

    // 手机左滑退出
    override fun onDestroy() {
        if(!hasSetResult) {
            val intent = Intent()
            intent.putExtra("return_value", "用户直接使用返回键")
            setResult(RESULT_OK, intent)
        }
        super.onDestroy()
    }

}