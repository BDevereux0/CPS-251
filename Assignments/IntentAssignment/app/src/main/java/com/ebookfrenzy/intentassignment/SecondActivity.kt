package com.ebookfrenzy.intentassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.intentassignment.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras?: return
        val image = extras.getString("qImage")
        val detail = extras.getString("qDetail")
        val title = extras.getString("qTitle")

        if (image != null) {
            binding.itemImage2.setImageResource(Data.images[image.toInt()])
        }
        binding.itemDetail2.append(detail)
        binding.itemTitle2.append(title)
    }

}
