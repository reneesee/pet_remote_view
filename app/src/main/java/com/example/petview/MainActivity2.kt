package com.example.petview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.VideoView
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

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layoutcamera)
        // Get the VideoView reference
        val videoView = findViewById<VideoView>(R.id.video_view)
        val uri = Uri.parse("android.resource://" + packageName + "/raw/flower_and_cake")
// Set the video source to the URL of the video stream
        //val videoUrl = "rtsp://192.168.1.73:554/live"

        videoView.setVideoURI(uri)

// Start playing the video stream
        videoView.start()
        val rewindButton: Button = findViewById(R.id.rewind)
        rewindButton.setOnClickListener {
            val currentPosition = videoView.currentPosition
            var newPosition = currentPosition - 1000 // 后退1秒
            if (newPosition < 0) {
                newPosition = 0
            }
            videoView.seekTo(newPosition)
            videoView.start()
        }
        val forwardButton: Button = findViewById(R.id.forward)
        forwardButton.setOnClickListener {
            val currentPosition = videoView.currentPosition
            var newPosition = currentPosition + 1000
            if (newPosition < 0) {
                newPosition = 0
            }
            videoView.seekTo(newPosition)
            videoView.start()
        }
        val button1 = findViewById<Button>(R.id.back)
        button1.setOnClickListener {
            val intent = Intent(this@MainActivity2, HomeActivity::class.java)
            startActivity(intent)
        }
        val changeButton: Button = findViewById(R.id.speaker)
        changeButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                    v.setBackgroundResource(R.drawable.speakergreen)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {

                    v.setBackgroundResource(R.drawable.speaker)
                }
            }
            true
        }

        }
    }

