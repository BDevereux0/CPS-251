package com.ebookfrenzy.coroutineassignmentv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter() :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var raOutput : TextView

        init {
            raOutput = itemView.findViewById(R.id.raOutput)
        }
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.raOutput.text = MainActivity.name
    }

    override fun getItemCount(): Int {
       return 1
    }
}