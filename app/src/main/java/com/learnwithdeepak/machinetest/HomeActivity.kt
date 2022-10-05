package com.learnwithdeepak.machinetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.learnwithdeepak.machinetest.screen1.FirstAct
import com.learnwithdeepak.machinetest.screen2.SecondAct

class HomeActivity : AppCompatActivity() {

    lateinit var screen1: Button
    lateinit var screen2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

       screen1 =  findViewById<Button>(R.id.screen1)
       screen2 =  findViewById<Button>(R.id.screen2)

        screen1.setOnClickListener{
            val intent = Intent(this, FirstAct::class.java)
            startActivity(intent)
        }

        screen2.setOnClickListener{
            val intent = Intent(this, SecondAct::class.java)
            startActivity(intent)
        }
    }
}