package com.example.friends.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friends.model.entity.photo.VkPhoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photo.view.*
import java.text.SimpleDateFormat
import java.util.*

import kotlin.collections.ArrayList



class PhotosAdapter: RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var photosList: ArrayList<VkPhoto> = ArrayList()

    fun setupPhotos(arrayList: List<VkPhoto>) {
        photosList.clear()
        photosList.addAll(arrayList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotosAdapter.PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(com.example.friends.R.layout.item_photo, parent, false))
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(itemViewHolder: PhotosAdapter.PhotoViewHolder, position: Int) {

        itemViewHolder.bind(photosList[position])
    }


    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(vkPhoto: VkPhoto) {
            Picasso.get().load(vkPhoto.sizes?.get(0)?.src).into(itemView.imageViewPhoto)

            val date = Date(vkPhoto.date.toLong()*1000)
            val formatForDateNow = SimpleDateFormat("E yyyy.MM.dd")
            itemView.textViewDate.text = "${formatForDateNow.format(date)}"
        }

    }
}