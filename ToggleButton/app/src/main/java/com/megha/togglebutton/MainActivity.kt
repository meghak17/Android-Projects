package com.megha.togglebutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image:ImageView = findViewById(R.id.image)
        val text:TextView = findViewById(R.id.textView)
        val toggle:ToggleButton = findViewById(R.id.toggleButton)

        toggle.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                image.visibility = View.INVISIBLE
                text.text="Image is invisible"
            }
            else{
                image.visibility = View.VISIBLE
                text.text="Image is visible"
            }
        }
    }
}