package com.ebookfrenzy.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ebookfrenzy.navigationproject.R
import com.ebookfrenzy.navigationproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    companion object;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.disImg1.setOnClickListener(Navigation.createNavigateOnClickListener(
                                        R.id.mainToDisplay,null))

        binding.disImg1.setOnClickListener{
            val action: MainFragmentDirections.MainToDisplay =
                MainFragmentDirections.mainToDisplay()
            action.imageNumberActionArgument = "Image 1"
            Navigation.findNavController(it).navigate(action)
        }

        binding.disImg2.setOnClickListener{
            val action: MainFragmentDirections.MainToDisplay =
                MainFragmentDirections.mainToDisplay()
            action.imageNumberActionArgument = "Image 2"
            Navigation.findNavController(it).navigate(action)
        }

        binding.disImg3.setOnClickListener{
            val action: MainFragmentDirections.MainToDisplay =
                MainFragmentDirections.mainToDisplay()
            action.imageNumberActionArgument = "Image 3"
            Navigation.findNavController(it).navigate(action)
        }
    }

}