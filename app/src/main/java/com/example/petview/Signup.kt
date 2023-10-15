package com.example.petview

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petview.ui.theme.PetViewTheme

class Signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layoutsignup)
        val button1=findViewById<Button>(R.id.pet_sign)
        val email=findViewById<EditText>(R.id.email)
        val psw=findViewById<EditText>(R.id.psw)
        button1.setOnClickListener {
            val email1 = email.text.toString()
            val password = psw.text.toString()
            if (email1 == "123@456.com" && password == "123456") {
                val intent = Intent(this@Signup, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        val signUpButton: Button = findViewById(R.id.signup)
        signUpButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Register")

            // 创建一个输入框
            val input = EditText(this)
            input.hint = "Please enter username and password"
            input.inputType = InputType.TYPE_CLASS_TEXT

            // 设置为对话框的视图
            builder.setView(input)

            // 设置对话框的按钮
            builder.setPositiveButton("ok") { dialog, _ ->
                val info = input.text.toString()
                if (info.isNotEmpty()) {
                    Toast.makeText(applicationContext, "The registration was successful and the information is：$info", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }

            builder.setNegativeButton("cancel") { dialog, _ ->
                dialog.cancel()
            }

            // 显示对话框
            builder.show()
        }






        }
    }


