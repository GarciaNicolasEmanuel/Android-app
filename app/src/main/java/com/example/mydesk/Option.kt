package com.example.mydesk

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_option.*

class Option : AppCompatActivity() {
    private val city: String = "buenos aires, ar"
    private val city2: String = "tandil, ar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_option)

        btn.setOnClickListener {
            val intent = Intent(this, Weather::class.java)
            intent.putExtra("name",city)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, Weather::class.java)
            intent.putExtra("name",city2)
            startActivity(intent)
        }
    }
}
