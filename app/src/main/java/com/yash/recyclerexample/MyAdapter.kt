package com.yash.recyclerexample

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val songs: List<Song>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var mListner : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListner = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view,mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtTitle.text = songs[position].title
        holder.txtDescription.text = songs[position].description
        var color = "#CCCCCC"
        if (position % 2==0){
            color = "#EEEEEE"
        }
        holder.container.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    class MyViewHolder(itemView: View , listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        var txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        var txtDescription = itemView.findViewById<TextView>(R.id.txtDescription)
        var container = itemView.findViewById<LinearLayout>(R.id.container)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
