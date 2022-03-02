package com.example.cadeaucommun.FEL.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cadeaucommun.R;
import com.example.cadeaucommun.loginActivity;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_activity);
    }

    public void registerClick(View view)
    {
        Intent reg_intent = new Intent(this, RegisterActivity.class);
        startActivity(reg_intent);
    }

    public void loginClick(View view)
    {
        Intent log_intent = new Intent(this, loginActivity.class);
        startActivity(log_intent);
    }
}