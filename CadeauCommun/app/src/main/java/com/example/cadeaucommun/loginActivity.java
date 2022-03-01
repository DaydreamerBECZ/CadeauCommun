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

    //Declaring credentials here :
    String email_user="chantal.lacroix@gmail.com";
    String username="ChanLac46";
    String password_user="Chantal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginSubmit(View view)
    {
        organizerSwitch = findViewById(R.id.organizerSwitch);
        userid = findViewById(R.id.userLog);
        password = findViewById(R.id.passLog);
        Toast msg = null;
        if ((email_user.equals(userid.getText())) || (username.equals(userid.getText()))) {
            if (organizerSwitch.isChecked()) {
                Intent orgIntent = new Intent(this, participantSelectionActivity.class);
                startActivity(orgIntent);
            }
            else
            {
                msg = Toast.makeText(this, "ok", Toast.LENGTH_LONG);
            }
        }
        else
        {
            msg = Toast.makeText(this, userid.getText() + " " + username + " " + password.getText(), Toast.LENGTH_LONG);
        }
        msg.show();
    }
}