package com.ebookfrenzy.eventexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.eventexample.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //var x = 1 //created to test if statement with returning true/false in event handler. Works!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener {
            binding.statusText.text = "Button clicked"
        }

        binding.myButton.setOnLongClickListener {
            binding.statusText.text = "Long button click"
            /*if (x==0) {
                true
            }else {*/
                false
           // }
            }

    }
}