package com.sum.catchimage

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.View.INVISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sum.catchimage.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageArray: ArrayList<ImageView>
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ArrayList:
        imageArray = ArrayList()
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        hideImages()



        object : CountDownTimer(15500, 1000) {
            override fun onFinish() {

                binding.textTime.text = "Time: 0"
                alertMessage()
            }


            override fun onTick(millisUntilFinished: Long) { //what to do every second
                binding.textTime.text = "Time: ${millisUntilFinished / 1000}"
            }


        }.start()  //Do NoT FORGET


    }

    fun increaseScore(view: View) {
        score += 1
        binding.textScore.text = "Score: $score"
        // Toast.makeText(this@MainActivity,"Sum",Toast.LENGTH_SHORT).show()
    }


    fun alertMessage() {
        val alert = AlertDialog.Builder(this)
            .setTitle("Game Over")
            .setMessage("Restart the Game")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                //Toast.makeText(this@MainActivity,"YES",Toast.LENGTH_SHORT).show()
                val intent = getIntent()
                finish() // onDestroy effective memory
                startActivity(intent)


            }).setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, id ->
                Toast.makeText(this@MainActivity, "NO", Toast.LENGTH_SHORT).show()

            }).show()

    }

    fun hideImages(){
        for(image in imageArray){
            image.visibility =INVISIBLE
        }
        choseOneImage()
    }

    fun choseOneImage(){
        val random = Random()
        val randomIndex =random.nextInt(9)
        imageArray[randomIndex].visibility = View.VISIBLE
    }
}