package com.example.cadeaucommun.FEL.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.example.cadeaucommun.R;

public class loginActivity extends AppCompatActivity {

    Switch organizerSwitch;
    EditText userid;
    EditText password;

    //Credentials of the user
    String uname="ChanLac46";
    String passwd="Chantal";

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
        if (this.uname.equals(userid.getText().toString()) && this.passwd.equals(password.getText().toString())) {
            if (organizerSwitch.isChecked())
            {
                Intent orgIntent = new Intent(this, eventManagerActivity.class);
                startActivity(orgIntent);
            }
            else
                displayMsg("Participant view in construction");
        }
        else{
            displayMsg("Invalid Credential");
            Log.d("Credentials are", userid.getText().toString() + " " + password.getText().toString());
        }
    }

    public void displayMsg(String message)
    {
        Toast msg = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        msg.show();
    }

    public void bypassLoginScreen(View view) {
        Intent orgIntent = new Intent(this, eventManagerActivity.class);
        startActivity(orgIntent);
    }
}