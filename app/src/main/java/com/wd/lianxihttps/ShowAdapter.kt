package com.wd.lianxihttps

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wd.lianxihttps.bean.ShowData

class ShowAdapter(private var context: Context, var show: ShowData) : RecyclerView.Adapter<ShowAdapter.MyViewholder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewholder {
        return MyViewholder(LayoutInflater.from(context).inflate(R.layout.item_recy, p0, false))
    }

    override fun getItemCount(): Int {
        return show.result.size
    }

    override fun onBindViewHolder(p0: MyViewholder, p1: Int) {
        p0.tvs.text = show.result.get(p1).name

        Glide.with(context).load(show.result.get(p1).logo).into(p0.imgs)
    }

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvs = itemView.findViewById<TextView>(R.id.tv)
            val imgs = itemView.findViewById<ImageView>(R.id.img)
    }

}