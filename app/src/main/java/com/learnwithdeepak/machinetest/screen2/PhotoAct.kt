package com.learnwithdeepak.machinetest.screen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.learnwithdeepak.machinetest.R
import com.learnwithdeepak.machinetest.screen1.email_tv

class PhotoAct : AppCompatActivity() {

    private lateinit var image_view: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        image_view = findViewById(R.id.image_view)

        var imageUrl : String = intent.getStringExtra("imageUrl").toString()

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(8))
        Glide.with(this)
            // .load(userList.get(position).thumbnailUrl)         //  this api not showing data that's why i'm adding static image
            .load(imageUrl)
            .apply(requestOptions)
            .into(image_view)

    }
}