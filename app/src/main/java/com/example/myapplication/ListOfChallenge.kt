package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Recyclerview.RecyclerAdapter

class ListOfChallenge : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_challenge)

        layoutManager= LinearLayoutManager(this)

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager= layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter= adapter


    }
}