package com.example.myapplication.Recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var title = arrayOf("Challenge One","Challenge Two","Challenge Three", "Challenge Four", "Challenge Five")
    private var details= arrayOf("item details","item details","item details","item details","item details")
    private var images  = intArrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.images4,R.drawable.images5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {

        return title.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.itemTitle.text= title[position]
        holder.itemDetail.text= details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage= itemView.findViewById(R.id.item_image)
            itemTitle= itemView.findViewById(R.id.item_title)
            itemDetail= itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {

                val position: Int = adapterPosition

                Toast.makeText(itemView.context,"you clicked on ${title[position]}",Toast.LENGTH_LONG).show()
            }


        }

    }

}