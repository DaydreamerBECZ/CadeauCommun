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
        if (user.equals("ChanLac46") && pass.equals("Chantal")) {
            if (organizerSwitch.isChecked())
            {
                Intent orgIntent = new Intent(this, participantSelectionActivity.class);
                startActivity(orgIntent);
            }
            else
                displayMsg("ok");
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