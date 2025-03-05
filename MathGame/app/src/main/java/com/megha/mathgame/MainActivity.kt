package com.megha.mathgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var add : Button
    lateinit var sub : Button
    lateinit var mul : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        add = findViewById(R.id.buttonadd)
        sub = findViewById(R.id.buttonsub)
        mul = findViewById(R.id.buttonmul)

        add.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(intent)
        }

        sub.setOnClickListener {

        }

        mul.setOnClickListener {

        }

    }
}