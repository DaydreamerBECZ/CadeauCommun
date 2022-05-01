package com.example.cadeaucommun.FEL.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cadeaucommun.BLL.Model.Participant;
import com.example.cadeaucommun.DAL.ConcreteDAOs.ParticipantDAO;
import com.example.cadeaucommun.R;

public class RegisterActivity extends AppCompatActivity {
    TextView fNameInput;
    TextView lNameInput;
    TextView usernameInput;
    TextView passwordInput;
    TextView passwordConfirmationInput;
    ParticipantDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fNameInput = findViewById(R.id.firstName_lbl);
        lNameInput = findViewById(R.id.lastName_lbl);
        usernameInput = findViewById(R.id.username_lbl);
        passwordInput = findViewById(R.id.password_lbl);
        passwordConfirmationInput = findViewById(R.id.password_lbl2);
    }

    public void registerUser(View view) {
        dao = new ParticipantDAO(this);

        Participant participant = new Participant();
        participant.setfName(fNameInput.getText().toString());
        participant.setlName(lNameInput.getText().toString());
        participant.setUsername(usernameInput.getText().toString());

        String password = passwordInput.getText().toString();
        if(password.equals(passwordConfirmationInput.getText().toString())){
            participant.setPassword(password);
        }
        else Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();

        dao.add(participant);
        Toast.makeText(this, "Successfully registered. Welcome to Cadeau Commun!", Toast.LENGTH_SHORT).show();
        Intent orgIntent = new Intent(this, eventManagerActivity.class);
        startActivity(orgIntent);
    }
}