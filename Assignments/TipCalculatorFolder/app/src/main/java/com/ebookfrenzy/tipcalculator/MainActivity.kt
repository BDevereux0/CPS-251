package com.ebookfrenzy.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var outputText : String
    private var errorMSG = "You must enter a bill amount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener{
            if (binding.billAmount.text.toString() == ""){
                binding.output.text = errorMSG
                outputText = errorMSG
            }else
                tipCalculation(binding.billAmount.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("savedString", outputText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val userEnteredValue = savedInstanceState.getString("savedString","")
        outputText = userEnteredValue
        binding.output.text = outputText
    }

    private fun tipCalculation(amount: String){
        val tenPercent = BigDecimal((amount.toDouble() * .1) + amount.toDouble()).
        setScale(2, RoundingMode.HALF_EVEN)
        val fifteenPercent = BigDecimal((amount.toDouble() * .15) + amount.toDouble()).
        setScale(2, RoundingMode.HALF_EVEN)
        val twentyPercent = BigDecimal((amount.toDouble() * .20) + amount.toDouble()).
        setScale(2, RoundingMode.HALF_EVEN)
        outputText ="10% = $tenPercent\n15% = $fifteenPercent\n20% = $twentyPercent "
        binding.output.text = outputText
    }


}