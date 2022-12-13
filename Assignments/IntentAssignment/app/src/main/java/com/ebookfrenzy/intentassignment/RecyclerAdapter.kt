package com.ebookfrenzy.intentassignment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random.Default.nextInt

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var imageID: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            imageID = itemView.findViewById(R.id.imageID)

            itemView.setOnClickListener {
                    val context = itemView.context
                    val i = Intent(context, SecondActivity::class.java)

                //todo Fix image issue
                    val intentTitle = itemTitle.text
                    val intentDetail = itemDetail.text
                    val intentImage = imageID.text

                    i.putExtra("qImage", intentImage.toString())
                    i.putExtra("qTitle", intentTitle)
                    i.putExtra("qDetail", intentDetail)
                    context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val randomTitle = nextInt(Data.titles.size)
        val randomDetail = nextInt(Data.details.size)
        val randomImage = nextInt(Data.images.size)

        viewHolder.itemTitle.text = Data.titles[randomTitle]
        viewHolder.itemDetail.text = Data.details[randomDetail]
        viewHolder.itemImage.setImageResource(Data.images[randomImage])
        viewHolder.imageID.text = randomImage.toString()
    }

    override fun getItemCount(): Int {
        return Data.titles.size
    }

}