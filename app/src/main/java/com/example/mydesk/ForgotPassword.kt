package com.example.mydesk

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_forgot_password)

        txtEmail=findViewById(R.id.txtEmail)
        auth= FirebaseAuth.getInstance()

    }
    fun send(view: View){
        val email:String=txtEmail.text.toString()

        if(!TextUtils.isEmpty(email)){

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this)  {
                        task ->
                    if (task.isSuccessful) {

                        startActivity(Intent(this,Login::class.java))
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_LONG).show()

                    }
                }
        }
    }
}
