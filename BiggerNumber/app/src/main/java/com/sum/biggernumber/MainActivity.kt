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
        var number1 = binding.button.text.toString().toInt()
        var number2 = binding.button2.text.toString().toInt()

        if(number1 > number2){
            //Correct Answer
                //Change background color
            binding.background.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct",Toast.LENGTH_SHORT).show()

        }else{
            //Show Wrong Answer
            binding.background.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong",Toast.LENGTH_SHORT).show()
        }
        //Pict the new random number
        generateNumber()

    }



    fun secondButton(view: View) {
        //Compare Number
        var number1 = binding.button.text.toString().toInt()
        var number2 = binding.button2.text.toString().toInt()

        if(number1 < number2){
            //Correct Answer
            //Change background color
            binding.background.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct",Toast.LENGTH_SHORT).show()

        }else{
            //Show Wrong Answer
            binding.background.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong",Toast.LENGTH_SHORT).show()
        }
        //Pict the new random number
        generateNumber()

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