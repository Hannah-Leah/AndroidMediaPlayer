package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnplay: Button
    private lateinit var btnstop: Button
    private lateinit var vwplayer : VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnplay = findViewById(R.id.buttonplay)
        btnstop = findViewById(R.id.buttonstop)
        vwplayer = findViewById(R.id.videoplayer)

        val videopath : String = "android.resource://" + packageName + "/" + R.raw.sunset
        var mpsound : MediaPlayer = MediaPlayer()

            btnplay.setOnClickListener { v -> run{
                mpsound = MediaPlayer.create(this, R.raw.klavier)
                mpsound.start()
                vwplayer.setVideoPath(videopath)
                vwplayer.start()
            }

            }

        btnstop.setOnClickListener { v -> run {
            mpsound.stop()
            vwplayer.stopPlayback()
        } }
    }
}