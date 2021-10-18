package com.example.myapplication.Recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.Challenge_details
import com.example.myapplication.R
import com.example.myapplication.api.user.model.DetailModel


class DetailAdapter(val detailModel: DetailModel):RecyclerView.Adapter<DetailViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_detail,parent,false)
        return DetailViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  detailModel.content!!.pictures!!.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

        return holder.bindView(detailModel.content!!.pictures!![position]!!)
    }


}

class DetailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val title : TextView = itemView.findViewById(R.id.detail_title)
    private val image : ImageView = itemView.findViewById(R.id.detail_image)


    fun bindView(detailModel: DetailModel.Content.Picture){

        val url = detailModel.file
        val changeUrl2 = url?.replace(":80","")
        Glide.with(itemView)
                .load(changeUrl2).dontAnimate()
                .skipMemoryCache(true) //2
                .diskCacheStrategy(DiskCacheStrategy.NONE) //3
                .into(image)

    }

}