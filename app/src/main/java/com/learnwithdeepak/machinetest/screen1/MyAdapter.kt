package com.learnwithdeepak.machinetest.screen1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learnwithdeepak.machinetest.R
import com.learnwithdeepak.machinetest.model.Datalist

class MyAdapter (val context: Context, val userList: List<Datalist>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private lateinit var mlistner : onItemClickListner

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onItemClickListner){
        mlistner = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.users_item_row, parent,false)
        return ViewHolder(itemView, mlistner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = userList[position].id.toString()
        holder.username.text = userList[position].username
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {

        var id: TextView
        var username: TextView

        init {
            id = itemView.findViewById(R.id.id)
            username = itemView.findViewById(R.id.username)
        }
        init {
            itemView.setOnClickListener{
                listner.onItemClick(adapterPosition)
            }
        }
    }
}