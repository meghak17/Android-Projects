package com.megha.miniproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtemail,edtpassword;
    String email="",password="";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtemail = findViewById(R.id.editEmail);
        edtpassword = findViewById(R.id.editPassword);

    }

    public  void btnLoginCLick(View view){
        email = edtemail.getText().toString().trim();
        password = edtpassword.getText().toString().trim();

        if (email.equals("")){
            edtemail.setError("Please Enter Email");
            edtemail.requestFocus();
            return;
        }

        if (password.equals("")){
            edtpassword.setError("Please Enter Password");
            edtpassword.requestFocus();
            return;
        }

        if(email.equals("admin@gmail.com")&&password.equals("1234"))
        {
            Intent intent = new Intent(this, AdminDashboardActivity.class);
            startActivity(intent);
        }
        else if (email.equals("user@gmail.com")&&password.equals("1234"))
        {
            Intent intent = new Intent(this, UserDashboardActivity.class);
            startActivity(intent);
        }
    }
}