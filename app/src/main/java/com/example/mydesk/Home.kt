package com.example.mydesk



import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*


class Home : AppCompatActivity() {
    private lateinit var dbReference: DatabaseReference
    private lateinit var uid:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_home)
        uid = intent.getStringExtra("uid")

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

        dbReference= FirebaseDatabase.getInstance().getReference("Users")

        if(!(uid==" ")){
            dbReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val result = dataSnapshot.child(uid).child("username")
                    val value = "Welcome ${result.value.toString()} and thanks for coming!"
                    findViewById<TextView>(R.id.message).text = value
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                }
            })
        }

    }


    override fun onBackPressed() {}
}
