package com.example.catchkenny

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.catchkenny.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var alert = AlertDialog.Builder(this@MainActivity2)
        alert.setTitle("Restart")
        alert.setMessage("Do you want to play again?")
        alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                var intent2 = Intent(this@MainActivity2,MainMenu :: class.java)
                startActivity(intent2)
            }

        })
        alert.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity2,"Game Over!",Toast.LENGTH_LONG).show()
                finish()
                onDestroy()
            }

        })
        alert.show()

        var scoreFromMain = intent
        var score = scoreFromMain.getIntExtra("score",-1)
        binding.textView3.text = "Your Score: $score"


    }
}