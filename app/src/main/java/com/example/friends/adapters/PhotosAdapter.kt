package com.example.friends.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friends.R
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.model.entity.photo.VkPhoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.friend_item.view.*
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotosAdapter: RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var photosList: ArrayList<VkPhoto> = ArrayList()

    fun setupPhotos(arrayList: List<VkPhoto>) {
        photosList.clear()
        photosList.addAll(arrayList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotosAdapter.PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))
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
            itemView.textViewDate.text = "Опубликовано: ${vkPhoto.date}"
        }

    }
}