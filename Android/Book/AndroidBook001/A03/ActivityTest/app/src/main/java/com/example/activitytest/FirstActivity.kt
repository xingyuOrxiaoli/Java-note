package com.example.activitytest

import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1:Button = findViewById(R.id.button1)
        button1.setOnClickListener({
            Toast.makeText(this,"弹窗信息长时间显示",Toast.LENGTH_LONG).show()
            Toast.makeText(this,"弹窗信息短时间显示",Toast.LENGTH_SHORT).show()
            // 显示 Intent
            val intent = Intent(this,SecondActivity::class.java )
            startActivity(intent)
        })
        val button2:Button = findViewById(R.id.button2)
        button2.setOnClickListener({
            val intent = Intent("com.example.activitytest.ACTION_START")
            intent.addCategory("com.example.activitytest.MY_CATEGORY")
            startActivity(intent)
        })

        val button3:Button = findViewById(R.id.button3)
        button3.setOnClickListener({
            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
            intent.data = "https://www.baidu.com".toUri()
            startActivity(intent)
        })

        val button4:Button = findViewById(R.id.button4)
        button4.setOnClickListener({
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "https://www.baidu.com".toUri()
            startActivity(intent)
        })

        val button6 :Button = findViewById(R.id.button6)
        button6.setOnClickListener({
            finish()
        })

        val button7:Button = findViewById(R.id.button7)
        button7.setOnClickListener({
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:10086".toUri()
            startActivity(intent)
        })
        // 传递数据
        val button8:Button = findViewById(R.id.button8)
        button8.setOnClickListener({
            val data = "====================== Hello SecondActivity ======================"
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("putExtra_Key" , data)
            startActivity(intent)
        })

    }

    // menu 相关代码
    // 显示出来
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main , menu)
        return true
    }

    // 添加事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_item_1 ->  Toast.makeText(this,"Menu_item_1",Toast.LENGTH_SHORT).show()
            R.id.menu_item_2 ->  Toast.makeText(this,"Menu_item_2",Toast.LENGTH_SHORT).show()
        }
        return true;
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        when(requestCode){
            1 -> if(resultCode == RESULT_OK){
                val returndata = data?.getStringExtra("return_value")
                Log.d("FirstActivity" , "===================returndata = $returndata=========================")
            }
        }
        super.onActivityResult(requestCode, resultCode, data, caller)
    }
}