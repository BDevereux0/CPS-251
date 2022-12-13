package com.ebookfrenzy.coroutineassignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.coroutineassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private fun addAdapter(){
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun addDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this //do i need this? https://www.geeksforgeeks.org/lifecycleobserever-with-activities-in-android/
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        Data.preventDuplication = false
        super.onCreate(savedInstanceState)
        addDataBinding()
        addAdapter()

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java] //can't call viewModel through the addDataBinding method.
        binding.setVariable(BR.myViewModel, viewModel)

        val outputObserver = Observer<String> { value ->

            if (Data.preventDuplication) {
                Data.globalList.add(value)
                adapter?.notifyDataSetChanged() //CRITICAL: Tells adapter to look at data class for update
            }
        }
        viewModel.output.observe(this, outputObserver)
    }

}