package com.learnwithdeepak.machinetest.screen2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.learnwithdeepak.machinetest.R
import com.learnwithdeepak.machinetest.model.PhotoModel

class MyAdapter2 (val context: Context, val userList: List<PhotoModel>) :
    RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    private lateinit var mlistner : onItemClickListner

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onItemClickListner){
        mlistner = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.photo_item_row, parent,false)
        return ViewHolder(itemView, mlistner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(8))
        Glide.with(context)
           // .load(userList.get(position).thumbnailUrl)         //  this api not showing data that's why i'm adding static image
            .load("https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
            .apply(requestOptions)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            itemView.setOnClickListener{
                listner.onItemClick(adapterPosition)
            }
        }
    }
}