package com.ebookfrenzy.coroutineassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var recyclerOutput: TextView

        init {
            recyclerOutput = itemView.findViewById(R.id.recyclerOutput)
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            viewHolder.recyclerOutput.text = Data.globalList[i]
    }

    override fun getItemCount(): Int {
        return Data.globalList.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }



}