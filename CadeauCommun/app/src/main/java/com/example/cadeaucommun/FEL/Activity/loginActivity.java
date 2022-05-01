package com.example.cadeaucommun.FEL.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadeaucommun.BLL.Model.Participant;
import com.example.cadeaucommun.DAL.ConcreteDAOs.ParticipantDAO;
import com.example.cadeaucommun.R;

import java.util.Optional;

public class loginActivity extends AppCompatActivity {
    TextView usernameInput;
    TextView passwordInput;
    ParticipantDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = findViewById(R.id.firstName_lbl);
        passwordInput = findViewById(R.id.password_lbl);
    }

    public void loginSubmit(View view) {
        dao = new ParticipantDAO(this);
        Participant aParticipantsUsername = dao.findParticipantByUsername(usernameInput.getText().toString());
        Participant aParticipantsPassword = dao.findParticipantByPassword(passwordInput.getText().toString());

        if(aParticipantsUsername != null && aParticipantsPassword != null){
            String foundUsername = aParticipantsUsername.getUsername();
            String foundPassword = aParticipantsPassword.getPassword();
            if (this.usernameInput.getText().toString().equals(foundUsername) && passwordInput.getText().toString().equals(foundPassword)) {
                Intent orgIntent = new Intent(this, eventManagerActivity.class);
                startActivity(orgIntent);
            } else Toast.makeText(this, "Invalid Credentials. Please try again.", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "We do not have an account registered to your name. Please register!", Toast.LENGTH_SHORT).show();
        Log.d("Submitted username is ", usernameInput.getText().toString() + ", submitted password is: " + passwordInput.getText().toString());
    }
}