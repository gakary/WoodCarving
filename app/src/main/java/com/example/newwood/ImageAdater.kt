package com.example.newwood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val context: Context,
    private val images : List<Image>,
    val listener : (Image)-> Unit
): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageSrc = view.findViewById<ImageView>(R.id.list_image_in)
        val title = view.findViewById<TextView>(R.id.list_Title)

        fun bindView(image: Image,listener: (Image) -> Unit){
            imageSrc.setImageResource(image.imageSrc)
            title.text = image.imageTitle
            itemView.setOnClickListener{
                listener(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.list_image,parent,false))


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position],listener)
    }

    override fun getItemCount(): Int = images.size
}