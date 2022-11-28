package com.ebookfrenzy.viewmodelandrecyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.viewmodelandrecyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter()

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        val resultObserver = Observer<String> {
                result -> binding.outputText.text = result.toString()
        }

        viewModel.getName().observe(this, resultObserver)
        binding.button.setOnClickListener {
            viewModel.nameToLower(binding.inputText.text.toString())
        }
    }

}