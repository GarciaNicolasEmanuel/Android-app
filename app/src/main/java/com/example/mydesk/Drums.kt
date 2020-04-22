package com.example.mydesk

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_drums.*

class Drums : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_drums)

        val mp1 = MediaPlayer.create(this, R.raw.hat1)
        val mp2 = MediaPlayer.create(this, R.raw.bom1)
        val mp3 = MediaPlayer.create(this, R.raw.hat2)
        val mp7 = MediaPlayer.create(this, R.raw.hat3)
        val mp4 = MediaPlayer.create(this, R.raw.bom2)
        val mp8 = MediaPlayer.create(this, R.raw.bom4)
        val mp9 = MediaPlayer.create(this, R.raw.hat4)
        val mp10 = MediaPlayer.create(this, R.raw.bom3)

        button1.setOnClickListener {
            mp1.start()
        }

        button2.setOnClickListener {
            mp2.start()
        }
        button3.setOnClickListener {
            mp3.start()
        }
        button4.setOnClickListener {
            mp4.start()
        }
        button7.setOnClickListener {
            mp7.start()
        }
        button8.setOnClickListener {
            mp8.start()
        }
        button9.setOnClickListener {
            mp9.start()
        }
        button10.setOnClickListener {
            mp10.start()
        }
    }
}
