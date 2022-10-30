    package com.ebookfrenzy.viewmodeldemo.ui.main


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.viewmodeldemo.R
import com.ebookfrenzy.viewmodeldemo.BR.myViewModel
//import androidx.lifecycle.Observer //removed for Data Binding Tutorial per Ch. 43




import com.ebookfrenzy.viewmodeldemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    /*private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!*/  //removed for Data Binding Tutorial per Ch. 43

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //_binding = FragmentMainBinding.inflate(inflater, container, false) //removed for Data Binding Tutorial per Ch. 43
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container, false)
        binding.setLifecycleOwner (this)
        return binding.root
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)

        //binding.resultText.text = viewModel.getResult().toString() //no longer needed because I'm using the Observer class for liveData (not the MainView)

        *//*val resultObserver = Observer<Float>{
            result -> binding.resultText.text = result.toString()
        }*//* //removed for Data Binding Tutorial per Ch. 43

        *//*viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.convertButton.setOnClickListener {
            if (binding.dollarText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollarText.text.toString())
               // binding.resultText.text = viewModel.getResult().toString() //this isn't needed either? IDK why...
            } else {
                binding.resultText.text = "No Value"
            }
        }*//* //removed for Data Binding Tutorial per Ch. 43
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)
    }

}