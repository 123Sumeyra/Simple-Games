package com.sum.biggernumber


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sum.biggernumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun firstButton(view: View) {
        //Compare the number
        checkAnswer(true)

        //Pict the new random number
        generateNumber()

    }
    
    fun secondButton(view: View) {
        //Compare Number
        checkAnswer(false)

        //Pict the new random number
        generateNumber()

    }

    private fun checkAnswer(isLeftButtonSelected:Boolean){
        var number1 = binding.button.text.toString().toInt()
        var number2 = binding.button2.text.toString().toInt()

        val isAnswerCorrect = if (isLeftButtonSelected) number1 > number2 else number2 > number1
        val toastMessage: String
        val backgroundColor: Int
        if (isAnswerCorrect) {
            toastMessage = "Correct!!"
            backgroundColor = Color.GREEN
        } else {
            toastMessage = "Wrong"
            backgroundColor = Color.RED
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        binding.background.setBackgroundColor(backgroundColor)




    }
    private fun generateNumber() {
        val randomSayi = (0..100).random()
        val lefNumber = randomSayi
        var rightNumber = randomSayi
        while (lefNumber == rightNumber){
            rightNumber= (0..100).random()

        }
        binding.button.text = lefNumber.toString()
        binding.button2.text = rightNumber.toString()
    }

}