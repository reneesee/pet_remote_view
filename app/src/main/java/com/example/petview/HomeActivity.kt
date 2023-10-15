package com.example.petview

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layouthome)
        val button1 = findViewById<Button>(R.id.button_last)
        button1.setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        val addButton: Button = findViewById(R.id.add)
        val newCameraImageView: ImageView = findViewById(R.id.newcamera)
        addButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enter the camera IP address")

            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton("Ok") { dialog, _ ->
                val ip = input.text.toString()
                if (ip.isNotEmpty()) {
                    Toast.makeText(applicationContext, "Entered successfully, the IP address is：$ip", Toast.LENGTH_SHORT).show()
                    newCameraImageView.visibility = View.VISIBLE
                }
                dialog.dismiss()
            }

            builder.setNegativeButton("cancel") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
        }
        val button2 = findViewById<Button>(R.id.set)
        button2.setOnClickListener {
            val intent = Intent(this@HomeActivity, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}

