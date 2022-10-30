package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.lifecycledemo.DemoObserver
//import com.ebookfrenzy.lifecycledemo.DemoOwner
import com.ebookfrenzy.lifecycledemo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
   // private lateinit var demoOwner: DemoOwner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycle.addObserver(DemoObserver())

       /* demoOwner = DemoOwner()
        demoOwner.startOwner()
        demoOwner.stopOwner()
        demoOwner.resumeOwner()
        demoOwner.destroyOwner()*/
    }


}