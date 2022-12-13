package com.ebookfrenzy.coroutineassignmentv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.ebookfrenzy.coroutineassignmentv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    companion object{
        var name: String = ""
    }

    fun addToRA(){
        binding.button.setOnClickListener{
            name = binding.inputTextfield.toString()
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addViewBinding()
        addMainViewModel()
        addAdapter()
    }

    private fun addViewBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun addAdapter(){
        layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter()
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun addMainViewModel(){
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

}