package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class EventsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)


        var database = FirebaseDatabase.getInstance().reference

        val createButton: Button = findViewById(R.id.create_button)
        createButton.setOnClickListener{

            //get xml elements
            val title: EditText = findViewById(R.id.editText_title_event)
            val evenType: EditText = findViewById(R.id.editText_evenType_event)
            val contact: EditText = findViewById(R.id.editText_contact_event)
            val date: EditText = findViewById(R.id.editText_date_event)
            val time: EditText = findViewById(R.id.editText_time_event)
            val location: EditText = findViewById(R.id.editText_location_event)
            var eventDescription: EditText = findViewById(R.id.editText_evenDescription)

            val userTitle = title.text.toString()
            val userEvenType = evenType.text.toString()
            val userContact = contact.text.toString()
            val userDate = date.text.toString()
            val userTime =  time.text.toString()
            val userLocation = location.text.toString()
            val userEventDescription = eventDescription.text.toString()


            //store in to firebase
            database.child(userTitle.toString()).setValue(Events(userTitle,userEvenType,userContact,userDate,userTime,userLocation,userEventDescription))
            Toast.makeText(applicationContext, "An event request has been sent !!", Toast.LENGTH_LONG).show()
            //clear the previous input
            title.getText().clear()
            evenType.getText().clear()
            contact.getText().clear()
            date.getText().clear()
            time.getText().clear()
            location.getText().clear()
            eventDescription.getText().clear()


            //switch to main page
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }
}

