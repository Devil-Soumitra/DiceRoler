package com.lucifer.imagediceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
    //Do a Dice roll when the App is Starts
        rollButton.setOnClickListener { rollDice() }

        rollDice()
}

    // Roll the Dice and update the screen with the results
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find the ImageView in the layout

        val diceImage: ImageView = findViewById(R.id.imageView)

       // Determime the image ID Base on the diceRoll result

        val drawbleResorce = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Use the Drawble ID to show the Dice Image in the layout

        diceImage.setImageResource(drawbleResorce)

        // Update the content description

        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}