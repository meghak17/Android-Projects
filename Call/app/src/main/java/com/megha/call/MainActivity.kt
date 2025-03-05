package com.megha.call

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var phone: EditText
    private lateinit var call: Button
    private var userNumber: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apply window insets to handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        phone = findViewById(R.id.editTextPhone)
        call = findViewById(R.id.buttonCall)

        // Set the button click listener
        call.setOnClickListener {
            userNumber = phone.text.toString()
            if (userNumber.isNotEmpty()) {
                startCall(userNumber)
            } else {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startCall(userNumber: String) {
        // Check if CALL_PHONE permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Request permission if not granted
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 100)
        } else {
            // Permission is already granted, proceed with the call
            makeCall(userNumber)
        }
    }

    private fun makeCall(userNumber: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$userNumber")
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            == PackageManager.PERMISSION_GRANTED
        ) {
            startActivity(intent)
        }
    }

    // Handle the permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the call
                makeCall(userNumber)
            } else {
                // Permission denied, show a message
                Toast.makeText(this, "Permission to make calls was denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

