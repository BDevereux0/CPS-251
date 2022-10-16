@file:Suppress("DEPRECATION")

package com.ebookfrenzy.addnamesavedata1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.addnamesavedata1.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get()= _binding!!
    private val errorMsg = "No names to display"

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun displayListFromMainView(){
        if (viewModel.getList().isEmpty()){
            binding.outputDisplay.text = errorMsg
        }else
            binding.outputDisplay.text = "" //clears the display otherwise append will keep adding names
        for (x: String in viewModel.getList()){
            binding.outputDisplay.append(x+"\n")
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        displayListFromMainView() //populates output when activity is created

        binding.addNameBtn.setOnClickListener{
            viewModel.addName(binding.enterName.text.toString())
            displayListFromMainView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}