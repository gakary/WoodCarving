package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle

    val validate = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        navView.setNavigationItemSelectedListener{



            val intentCam = Intent(this, ArticlesActivity::class.java)
            val intentPromote = Intent(this, CamActivity::class.java)
            val intentMap = Intent(this, MapsActivity::class.java)
            val intentHoldEvent = Intent(this, EventsActivity::class.java)
            val intentLogout = Intent(this, LoginActivity::class.java)

            /*article
           1  Articles
           2  Upload Promote
            3 Near Shop
            4 Hold Event
            5  Logout
             */

            when(it.itemId){
                R.id.na1 -> startActivity(intentCam)
                R.id.na2 -> startActivity(intentPromote)
                R.id.na3 -> startActivity(intentMap)
                R.id.na4 -> startActivity(intentHoldEvent)
                R.id.na5 -> startActivity(intentLogout)
            }

            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(toggle.onOptionsItemSelected(item)){
            return true
        }else if(toggle==null){
            Toast.makeText(applicationContext,"The toggle ,it was null",Toast.LENGTH_SHORT).show()
        }else if(validate!=0){
            Toast.makeText(applicationContext,"It was null",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}