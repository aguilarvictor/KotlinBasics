package com.example.diceRoller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diceRoller.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /*
    * Function rollDice
    * Instances a new object of Dice type, defining the number of sides
    * Roll method is called from Dice class
    * Value is displayed with the related image resource
    */
    private fun rollDice() {
        val diceOne = Dice(6)
        val diceRoll = diceOne.roll()

        /* Find the image view in the layout */
        val diceImage: ImageView = findViewById(R.id.imageView)

        /* Assign resource reference to variable to call setImageResource method only once */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        /* Add the content description for screen readers */
        diceImage.contentDescription = diceRoll.toString()
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
