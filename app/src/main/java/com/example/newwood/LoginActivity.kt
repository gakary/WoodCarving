package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    //firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val registertext: TextView = findViewById(R.id.textView_register_now)

        registertext.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val loginButton: Button = findViewById(R.id.button_login)

        loginButton.setOnClickListener{
            login()
        }

    }

    private fun login() {
        //Get the user input of email and password
        val email: EditText = findViewById(R.id.editText_email_login)
        val password: EditText = findViewById(R.id.editText_password_login)

        //if there is a error of SPAN_EXCLUSIVE_EXCLUSIVE , it's not the code issue , it might caused by pixel phone of keyboard
        if(email.text.isEmpty()||password.text.isEmpty()){
            //alert the remind to user
            Toast.makeText(this,"Please input all the fields , and try again!", Toast.LENGTH_SHORT)
                .show()
            return
        }//else
        val userEmail = email.text.toString()
        val userPassword = password.text.toString()

        //firebase process
        auth.signInWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, move on to main page
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(baseContext, "Success, Welcome! ",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed. ",
                        Toast.LENGTH_SHORT).show()
                }
            }
            //exception
            .addOnFailureListener{
                Toast.makeText(this,"Error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT)
                    .show()
            }
    }
}