package com.learnwithdeepak.machinetest.screen2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learnwithdeepak.machinetest.ApiInterface
import com.learnwithdeepak.machinetest.R
import com.learnwithdeepak.machinetest.model.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondAct : AppCompatActivity() {

    lateinit var myAdapter2: MyAdapter2
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var recyclerView : RecyclerView
    lateinit var context : Context
    lateinit var adapter: ConcatAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        context= this
        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.setHasFixedSize(true)
        gridLayoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = gridLayoutManager

        getData()
    }


    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getphotosData()

        retrofitData.enqueue(object : Callback<List<PhotoModel>?> {
            override fun onResponse(
                call: Call<List<PhotoModel>?>,
                response: Response<List<PhotoModel>?>
            ) {
                val responseBody = response.body()
                myAdapter2 = responseBody?.let { MyAdapter2(context , it) }!!
                myAdapter2.notifyDataSetChanged()
                recyclerView.adapter= myAdapter2

                myAdapter2.setOnItemClickListner(object: MyAdapter2.onItemClickListner {
                    override fun onItemClick(position: Int) {

                       // Toast.makeText(context,"You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                        val intent =  Intent(context, PhotoAct::class.java)
                        intent.putExtra("imageUrl", "https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(call: Call<List<PhotoModel>?>, t: Throwable) {
                Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}