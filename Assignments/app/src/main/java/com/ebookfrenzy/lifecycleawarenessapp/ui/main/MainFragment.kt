package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.lifecycleawarenessapp.DemoObserver
import com.ebookfrenzy.lifecycleawarenessapp.databinding.FragmentMainBinding
import java.time.LocalDateTime


class MainFragment : Fragment() {
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun displayEvents(){

        if (viewModel.getText().isNotEmpty()) {
            for (x: String in viewModel.getText()) {
                if (x != "****"){
                    binding.outputTextView.append("on$x was fired on "+ LocalDateTime.now().toString()
                            + "\n")
                }else{
                    binding.outputTextView.append("****\n")
                }
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        lifecycle.addObserver(DemoObserver())
        displayEvents()

    }

}