package com.megha.sendgmail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.megha.sendgmail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainBinding.buttonSend.setOnClickListener{
            val userAddress = mainBinding.editTextAddress.text.toString()
            val userSubject = mainBinding.editTextSubject.text.toString()
            val userMessage = mainBinding.editTextMessage.text.toString()
            sendEmail(userAddress, userSubject, userMessage)
        }
    }
    @SuppressLint("QueryPermissionsNeeded")
    fun sendEmail(userAddress: String, userSubject: String, userMessage: String){
        val emailAddresses = arrayOf(userAddress)

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddresses)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject)
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage)

        if (emailIntent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(emailIntent,"Choose an app"))
        }

    }
}