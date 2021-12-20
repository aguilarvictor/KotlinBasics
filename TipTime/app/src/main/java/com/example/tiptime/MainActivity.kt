package com.example.tiptime

import android.icu.text.NumberFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Set a click listener on the Calculate button and call CalculateTip fun */
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun calculateTip() {
        /* 1. Get the cost of service. Convert value from string to double */
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null) {
            binding.tipResult.text = "Enter a valid service cost."
            return
        }

        /* 2. Get the tip percentage from RadioButton group */
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        /* 3. Calculate tip */
        var tip = cost * tipPercentage

        /* 4. Calculate round up if option active */
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        /* 5. Format tip for display currency value */
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        /* 6. Display amount */
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}