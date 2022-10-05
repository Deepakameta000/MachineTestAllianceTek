package com.learnwithdeepak.machinetest.screen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.learnwithdeepak.machinetest.MapsActivity
import com.learnwithdeepak.machinetest.R

lateinit var id_tv: TextView
lateinit var name_tv: TextView
lateinit var username_tv: TextView
lateinit var email_tv: TextView
lateinit var suite_tv: TextView
lateinit var street_tv: TextView
lateinit var city_tv: TextView
lateinit var zipcode_tv: TextView
lateinit var lat_tv: TextView
lateinit var lng_tv: TextView
lateinit var showMap: AppCompatButton
lateinit var late1 : String
lateinit var long1 : String

class UserDetailAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        id_tv = findViewById(R.id.id_tv)
        name_tv = findViewById(R.id.name_tv)
        username_tv = findViewById(R.id.username_tv)
        email_tv = findViewById(R.id.email_tv)
        suite_tv = findViewById(R.id.suite_tv)
        street_tv = findViewById(R.id.street_tv)
        city_tv = findViewById(R.id.city_tv)
        zipcode_tv = findViewById(R.id.zipcode_tv)
        lat_tv = findViewById(R.id.lat_tv)
        lng_tv = findViewById(R.id.lng_tv)
        showMap = findViewById(R.id.showMap)


        id_tv.text ="Id: "+ intent.getIntExtra("id", 0).toString()
        name_tv.text ="Name: "+ intent.getStringExtra("name").toString()
        username_tv.text ="Username: "+ intent.getStringExtra("username").toString()
        email_tv.text ="Email: "+ intent.getStringExtra("email").toString()
        suite_tv.text = "Suite: "+ intent.getStringExtra("suite").toString()
        street_tv.text = "Street: "+ intent.getStringExtra("street").toString()
        zipcode_tv.text = "Zip Code: "+ intent.getStringExtra("zipcode").toString()
        city_tv.text = "City: "+ intent.getStringExtra("city").toString()
        lat_tv.text = intent.getStringExtra("lat").toString()
        lng_tv.text = intent.getStringExtra("lng").toString()

        showMap.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("lat", lat_tv.text)
            intent.putExtra("lng", lng_tv.text)
            startActivity(intent)
        }
    }
}