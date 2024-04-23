package com.example.catchkenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.catchkenny.databinding.ActivityMain2Binding
import com.example.catchkenny.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }

    fun startGame(view: View){

        var intent3 = Intent(this@MainMenu,MainActivity :: class.java)
        startActivity(intent3)
    }
}