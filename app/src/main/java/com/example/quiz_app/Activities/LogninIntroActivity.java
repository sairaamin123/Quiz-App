package com.example.quiz_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogninIntroActivity extends AppCompatActivity {

    Button getStarted;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lognin_intro);
        mAuth = FirebaseAuth.getInstance();

        // Check whether user is logged in or not!
        if(mAuth.getCurrentUser()!=null){
            Toast.makeText(this, "You are already logged in!", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(LogninIntroActivity.this,MainActivity.class);
            startActivity(intent);
            finish(); // to finish the activity
        }
        getStarted = findViewById(R.id.btnGetStarted);
        getStarted.setOnClickListener(v -> {
            Intent intent=new Intent(LogninIntroActivity.this, LogIn_Activity.class);
            startActivity(intent);
            finish(); // to finish the activity
        });
    }
}