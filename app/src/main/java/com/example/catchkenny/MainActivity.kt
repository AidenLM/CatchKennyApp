package com.example.catchkenny

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.catchkenny.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var screenX = 0
    private var screenY = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenX = displayMetrics.widthPixels
        screenY = displayMetrics.heightPixels

        score = 0

        startGame(view)


    }



    private fun startGame(view : View) {
        binding.textView.text = "Score: ${score}"
        object : CountDownTimer(10000,600){
            override fun onTick(millisUntilFinished: Long) {
                val time = millisUntilFinished/1000
                binding.textView2.text = "Time: ${time}"
                val rndmX = Random.nextInt(screenX - binding.imageView.measuredWidth)
                val rndmY = Random.nextInt(screenY - 2 * binding.imageView.measuredHeight)
                binding.imageView.x = rndmX.toFloat()
                binding.imageView.y = rndmY.toFloat()
            }

            override fun onFinish() {
                //binding.imageView.visibility = View.INVISIBLE
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
                /*
                val alert =  AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Restart")
                alert.setMessage("Do you want try again?")
                alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        // start menu activity
                        score = 0
                        startGame(view)

                    }
                })
                alert.setNegativeButton("No", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity,"Game Over.",Toast.LENGTH_SHORT).show()
                    }

                })
                alert.show()

                 */
            }
        }.start()

    }

    fun imageClick(view: View){

        score++
        binding.textView.text = "Score: $score"
    }

}