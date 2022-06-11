package com.example.newwood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.newwood.ArticlesActivity.Companion.INTENT_PARCELABLE

class DetailArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)

        val requestCode = 100;

        if(requestCode==100&&requestCode!=0){


//get xml elements
        val image = intent.getParcelableExtra<Image>(INTENT_PARCELABLE)

        val imgSrc = findViewById<ImageView>(R.id.article_Img)
        val imgTitle = findViewById<TextView>(R.id.article_Title)
        val imgDesc = findViewById<TextView>(R.id.article_Content)


        if (image != null&&requestCode==100) {
            imgSrc.setImageResource(image.imageSrc)
        }
        if (image != null&&requestCode==100) {
            imgTitle.text = image.imageTitle
        }
        if (image != null&&requestCode==100) {
            imgDesc.text = image.imageDesc
        }
        }
    }
}