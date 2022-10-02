package com.ebookfrenzy.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.androidsample.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.* - removed because i'm using view binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) removed because i'm using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun convertCurrency(view: View){
        if (binding.dollarText.text.isNotEmpty()){

            val dollarValue = binding.dollarText.text.toString().toFloat()

            val euroValue = dollarValue * 0.85f

            binding.textView.text = euroValue.toString()
        }else {
            binding.textView.text = getString(R.string.no_value_string)
        }
    }
}