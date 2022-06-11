package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    //firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val loginText: TextView = findViewById(R.id.textView_login_now)
        loginText.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val registerButton: TextView = findViewById(R.id.button_register)
        registerButton.setOnClickListener{
            //Get the user input of email and password

            //Signup method
            SignUp()

        }

    }

    private fun SignUp() {
        val email = findViewById<EditText>(R.id.editText_email_register)
        val password = findViewById<EditText>(R.id.editText_password_register)
        val confirmPassword = findViewById<EditText>(R.id.editText_confirmpw)


        //if there is a error of SPAN_EXCLUSIVE_EXCLUSIVE , it's not the code issue , it might caused by pixel phone of keyboard

        if(email.text.isEmpty()||password.text.isEmpty()||confirmPassword.text.isEmpty()){
            //alert the remind to user
            Toast.makeText(this,"Please input all the fields , and try again!", Toast.LENGTH_SHORT)
                .show()
            return
        }else if(password.text.toString()!=confirmPassword.text.toString()){
            Toast.makeText(this,"Password and Confirm Password not the same!", Toast.LENGTH_SHORT)
                .show()
            return
        }else if(password.text.toString() == confirmPassword.text.toString()){

        }

        //toString : convert the input to String
        val UsertEmail = email.text.toString()
        val UserPassword = password.text.toString()


        //firebase process
        auth.createUserWithEmailAndPassword(UsertEmail,UserPassword).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, move on to main page
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                Toast.makeText(baseContext, "Register Success, Welcome! ",
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