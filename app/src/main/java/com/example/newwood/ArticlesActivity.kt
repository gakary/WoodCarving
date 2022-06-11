package com.example.newwood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArticlesActivity : AppCompatActivity() {


    companion object{val INTENT_PARCELABLE = "OBJECT_INTENT"}
    val requestCode = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        if(INTENT_PARCELABLE!=null&&requestCode==100){


        //apply the article image and articles content
        val imageList = listOf<Image>(
        Image(R.drawable.img1,"What is Wood Carving?","Wood carving is a form of woodworking by means of a cutting tool (knife) in one hand or a chisel by two hands or with one hand on a chisel and one hand on a mallet, resulting in a wooden figure or figurine, or in the sculptural ornamentation of a wooden object. The phrase may also refer to the finished product, from individual sculptures to hand-worked mouldings composing part of a tracery."),
        Image(R.drawable.img2,"Intricate Wooden Sculptures Of 21-Year-Old Vietnamese Artisan Make A Mark","Tran Duy, an amazing sculptor from Vietnam, is making waves in the art world by his breathtaking wooden sculptures, He starting to break out of the tradition of wood carving such as building the japan anime to attract the young people."),
        Image(R.drawable.img3,"Nowadays HK craftsmanship ","Nowadays, Hong Kong has a lot of traditional buildings and iconic stores that have been demolished  because of the march to modernity it causes some of Hong Kong's traditional craftsmanship to decline, such as the Wood Carving Technique. On the other hand, nearly all the craftsmen who know the traditional craftsmanship with extensive experience usually have a certain age."),
        Image(R.drawable.img4,"Hong Kong traditional wood carving shop","The traditional Wood Carving Technique in Hong Kong usually creates some carvings about the religions, such as character idols, temple decorations, spirit tablets, and traditional Cantonese restaurant decorations . Although keeping the conventional rule is good, it causes a situation that is only suitable for specifying audience to purchase, bringing on The Wood Carving Technique industry is harder to survive in the 21st-century business environment."),
        Image(R.drawable.img5,"Handmade statues of deities","Different handmade statues of deities and traditional folk tales characters are placed together.")
        )

        //get the xml
        val recyclerView = findViewById<RecyclerView>(R.id.photoRecycleView)
        //recyclerview list , detail setting
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        //detailArticleActivity process
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this,DetailArticleActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }
        }else{

        }
    }
}