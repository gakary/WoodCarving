package com.example.newwood

import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class CamActivity : AppCompatActivity() {


    lateinit var imageView: ImageView
    lateinit var button: Button
    lateinit var buttonPick: Button
    lateinit var buttonUpload: Button

    val REQUEST_IMAGE_CAPTURE = 100 //request Code for camera

    companion object {
        val PHOTO_REQUEST_CODE = 101 //request Code for select photo
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam)

        //get the xml elements and assign to variables
        imageView = findViewById(R.id.image_upload)
        buttonPick = findViewById(R.id.btn_pickPhoto)
        button = findViewById(R.id.btn_takephoto)
        buttonUpload = findViewById(R.id.btn_upload)

        //when click the button it start the pickImageGallery method
        buttonPick.setOnClickListener {
            pickImageGallery()
        }

        //when click the button it start the upload method
        buttonUpload.setOnClickListener {
            uploadImage()
        }

        button.setOnClickListener {

            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            try {
                //starting the camera
                startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) { //fail exception
                Toast.makeText(this, "Error:" + e.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    private fun uploadImage() {
        //when the image was not null and press upload it will upload and refresh the page
        var filepath = true;
        if (filepath != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
                //success upload
            Toast.makeText(applicationContext, "File Uploaded", Toast.LENGTH_LONG).show()
        } else {
                //fail upload
            Toast.makeText(applicationContext, "Failed to Upload", Toast.LENGTH_LONG).show()
        }

    }

    private fun pickImageGallery() {
        //turn to the phone gallery
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,PHOTO_REQUEST_CODE)
    }

    //check the which type of signal was send to there , and apply to the which action
    override fun onActivityResult(requestCode:Int, resultCode:Int,data:Intent?){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data")as Bitmap
            imageView.setImageBitmap(imageBitmap)

        }else if(requestCode == PHOTO_REQUEST_CODE && resultCode == RESULT_OK){

            imageView.setImageURI(data?.data)


        }
        else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }
}