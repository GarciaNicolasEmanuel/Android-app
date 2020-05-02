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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_register)

        txtName=findViewById(R.id.txtName)
        txtLastName=findViewById(R.id.txtLastName)
        txtEmail=findViewById(R.id.txtEmail)
        txtPassword=findViewById(R.id.txtPassword)

        database= FirebaseDatabase.getInstance()
        dbReference= FirebaseDatabase.getInstance().reference
        auth= FirebaseAuth.getInstance()

        getStarted.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            intent.putExtra("uid"," ")
            startActivity(intent)

        }

    }
    fun register(view: View) {
        createNewAccount()
    }
    private fun createNewAccount(){
        val name:String=txtName.text.toString()
        val lastName:String=txtLastName.text.toString()
        val email:String=txtEmail.text.toString()
        val password:String=txtPassword.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && email.contains("@")){

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                     task ->
                    if (task.isComplete){
                        val user=auth.currentUser
                        val uid=user!!.uid.toString()
                        dbReference.child("Users").child(uid).child("username").setValue(name)
                        dbReference.child("Users").child(uid).child("userlastname").setValue(lastName)
                        Toast.makeText(baseContext, "Authentication successful.",
                            Toast.LENGTH_SHORT).show()
                        action()
                    }else {

                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
            }

        }else{
            Toast.makeText(baseContext, "You must complete each option and email using @.",
                    Toast.LENGTH_LONG).show()

        }

    }
    private fun action(){
        startActivity(Intent(this,Login::class.java))
    }

}
