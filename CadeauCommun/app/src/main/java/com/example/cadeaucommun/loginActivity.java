package com.example.cadeaucommun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    Switch organizerSwitch;
    EditText userid;
    EditText password;

    //Credentials of the user
    String uname="ChanLac46";
    String pass="Chantal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        organizerSwitch = findViewById(R.id.organizerSwitch);
        userid = findViewById(R.id.userLog);
        password = findViewById(R.id.passLog);
    }

    public void loginSubmit(View view)
    {
        String user = userid.getText().toString();
        String pass = password.getText().toString();
        if (user.equals(uname) && pass.equals(pass)) {
            if (organizerSwitch.isChecked())
            {
                Intent orgIntent = new Intent(this, eventManagerActivity.class);
                startActivity(orgIntent);
            }
            else
                displayMsg("Participant view in construction");
        }
        else
            displayMsg("Invalid Credential");
    }

    public void displayMsg(String message)
    {
        Toast msg = Toast.makeText(this, message, Toast.LENGTH_LONG);
        msg.show();
    }
}