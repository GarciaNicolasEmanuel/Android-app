package com.example.mydesk

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPassword: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_main)

        txtUser=findViewById(R.id.txtUser)
        txtPassword=findViewById(R.id.txtPassword)

        auth= FirebaseAuth.getInstance()

        register.setOnClickListener {
            val intent = Intent(baseContext, Register::class.java)
            startActivity(intent)
        }
    }
    fun forgotPassword(view: View){
        startActivity(Intent(this,ForgotPassword::class.java))
    }

    fun login(view: View){
        loginUser()
    }
    private fun action(){
        startActivity(Intent(this,Home::class.java))
    }

    private fun loginUser(){
        val email:String=txtUser.text.toString()
        val password:String=txtPassword.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext, "Authentication was successful.",
                            Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                        action()
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_LONG).show()

                    }

                }
        }

    }
    override fun onBackPressed() {
    }
}
