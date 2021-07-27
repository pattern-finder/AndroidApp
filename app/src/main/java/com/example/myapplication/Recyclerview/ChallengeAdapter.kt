package com.example.myapplication.Recyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Challenge_details
import com.example.myapplication.Profile
import com.example.myapplication.R
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.user.model.ChallengeModel


class ChallengeAdapter(val challengeModel: ChallengeModel): RecyclerView.Adapter<ChallengeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ChallengeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  challengeModel.content!!.size
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {

        return holder.bindView(challengeModel.content!![position] )
    }

}

class ChallengeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private  val title: TextView = itemView.findViewById(R.id.item_title)
    private val description : TextView = itemView.findViewById(R.id.item_detail)
    private val id : TextView = itemView.findViewById(R.id.item_id)


    init {

        itemView.setOnClickListener { v:View ->
            val position:Int = adapterPosition

            val intent = Intent(itemView.context,Challenge_details::class.java)
            intent.putExtra("ayoub",id.text)
            itemView.context.startActivity(intent)
            //val intent = Intent(itemView.context,Challenge_details::class.java)
            Toast.makeText(itemView.context,"you are ${id.text}",Toast.LENGTH_LONG).show()


        }
    }

    fun bindView(challengeModel: ChallengeModel.Content?){

        title.text = challengeModel!!.name
        description.text= challengeModel.instructions
        id.text = challengeModel.id


    }


}