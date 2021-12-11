package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /*
    * Function rollDice
    * Instances a new object of Dice type, defining the number of sides
    * Roll method is called from Dice class
    * Value is assigned to TextView
    */
    private fun rollDice() {
        val diceOne = Dice(6)
        val diceRoll = diceOne.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 *  Class Dice creates a new dice object
 */
class Dice(private val numSides: Int) {
    /*
    * Method to return a random number when dice is rolled
    * Range is from 1 to numSides, defined when object is created
    */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
