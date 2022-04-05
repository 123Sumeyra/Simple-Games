package com.sum.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.sum.tic_tac_toe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    var player1 = 0
    var player2 = 1
    var activePlayer = player1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)



    }

    override fun onClick(view: View?) {
        var btnClicked = findViewById<Button>(view!!.id) // btnClicked = button should be
        //btnClicked.setText("X")
        if (activePlayer == player1) {
            btnClicked.text = "X"
            btnClicked.isClickable = false
            activePlayer = player2
            btnClicked.setBackgroundColor(Color.CYAN)
            binding.textViewTurn.text = "Player2 Turn"







        } else {
            btnClicked.text = "0"
            btnClicked.isClickable = false
            checkForVictory(activePlayer)
            activePlayer = player1
            btnClicked.setBackgroundColor(Color.RED)

            binding.textViewTurn.text = "Player1 Turn"
        }

    }

    private fun checkForVictory(activePlayer:Int):Boolean{

        val btn1 =binding.button1.text.toString()
        val btn2 =binding.button2.text.toString()
        val btn3 =binding.button3.text.toString()
        val btn4 =binding.button4.text.toString()
        val btn5 =binding.button5.text.toString()
        val btn6 =binding.button6.text.toString()
        val btn7 =binding.button7.text.toString()
        val btn8 =binding.button8.text.toString()
        val btn9 =binding.button9.text.toString()



        //Horizontal Victory
       if(btn1 == btn2  && btn2 == btn3){
           println("Kazandı $activePlayer")
          // binding.textViewTurn.text=  "Winner is $activePlayer"
           return true

       }
        if(btn4 == btn5  && btn5 == btn6){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            println("Kazandı $activePlayer")
            return true

        }
        if(btn7 == btn8  && btn8 == btn9){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }


        //Vertical Victory
        if(btn1 == btn4  && btn4 == btn7){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }
        if(btn2 == btn5  && btn5 == btn8){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }
        if(btn3 == btn6  && btn6 == btn9){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }

        //Diagonal Victory
        if(btn1 == btn5  && btn5 == btn9){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }
        if(btn3 == btn5  && btn5 == btn7){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            return true

        }
        return false





        //


    }

    /*fun sayWinner(){
        var winner = binding.textViewTurn.text.toString()
        if( winner == "Player2 Turn"){
             binding.textViewTurn.text=  "Winner is Player2"

        }else{
            binding.textViewTurn.text = "Winner is Player2"

        }

    }*/

}