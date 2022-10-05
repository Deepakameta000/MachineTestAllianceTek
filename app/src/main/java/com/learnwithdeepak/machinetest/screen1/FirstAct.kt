package com.learnwithdeepak.machinetest.screen1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learnwithdeepak.machinetest.ApiInterface
import com.learnwithdeepak.machinetest.R
import com.learnwithdeepak.machinetest.model.Datalist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstAct : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView : RecyclerView
    lateinit var context : Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Datalist>?> {
            override fun onResponse(
                call: Call<List<Datalist>?>,
                response: Response<List<Datalist>?>
            ) {
                val responseBody = response.body()
                myAdapter = responseBody?.let { MyAdapter(baseContext, it) }!!
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter= myAdapter

                myAdapter.setOnItemClickListner(object: MyAdapter.onItemClickListner {
                    override fun onItemClick(position: Int) {

                        val intent =  Intent(context, UserDetailAct::class.java)
                        intent.putExtra("id", responseBody[position].id)
                        intent.putExtra("name", responseBody[position].name)
                        intent.putExtra("username", responseBody[position].username)
                        intent.putExtra("email", responseBody[position].email)
                        intent.putExtra("street", responseBody[position].address.street)
                        intent.putExtra("suite", responseBody[position].address.suite)
                        intent.putExtra("city", responseBody[position].address.city)
                        intent.putExtra("zipcode", responseBody[position].address.zipcode)
                        intent.putExtra("lat", responseBody[position].address.geo.lat)
                        intent.putExtra("lng", responseBody[position].address.geo.lng)
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(call: Call<List<Datalist>?>, t: Throwable) {
                Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
