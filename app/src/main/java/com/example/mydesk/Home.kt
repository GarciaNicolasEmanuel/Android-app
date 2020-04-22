package com.example.mydesk



import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*


class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_home)

        card1.setOnClickListener {
            val intent = Intent(baseContext, WebView::class.java)
            startActivity(intent)
        }
        card2.setOnClickListener {
            val intent = Intent(baseContext, Option::class.java)
            startActivity(intent)
        }
        card3.setOnClickListener {
            val intent = Intent(baseContext, Camera::class.java)
            startActivity(intent)
        }
        card4.setOnClickListener {
            val intent = Intent(baseContext, Drums::class.java)
            startActivity(intent)
        }
        logOut.setOnClickListener {
            val intent = Intent(baseContext, Login::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {}
}
