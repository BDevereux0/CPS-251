package com.ebookfrenzy.viewmodelandrecyclerviewpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.viewmodelandrecyclerviewpractice.databinding.ActivityMainBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val Tag1 = "error123"


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var recyclerOutput: TextView

        init {
            recyclerOutput = itemView.findViewById(R.id.recyclerOutput)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 2

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val test = MainActivity().binding
        val y = MainActivity().viewModel
        val x: String = MainViewModel().getLowerName().toString()
        Log.i(Tag1,x)
        viewHolder.recyclerOutput.text = x

        val resultObserver = Observer<String> {
                result -> test.outputText.text = result.toString()
        }

        y.getName().observe(MainActivity(), resultObserver)
        test.button.setOnClickListener {
            y.nameToLower(test.inputText.text.toString())
        }

    }
}