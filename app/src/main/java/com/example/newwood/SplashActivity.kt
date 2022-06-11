package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        //remove the top bar of the phone
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        Handler().postDelayed(
            {
                //move on to main activity
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish() //finish this page then leave
            },
            2000
        ) // give some delay to switch to the main page

        // END
    }
}