package com.example.cadeaucommun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class eventManagerActivity extends AppCompatActivity {

    Button eventButton;
    Button eventCreationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_manager);
        eventButton = findViewById(R.id.eventButton);
        eventCreationButton = findViewById(R.id.eventCreateButton);
    }

    public void eventClick(View view)
    {
        Intent participants = new Intent(this, participantSelectionActivity.class);
        startActivity(participants);
    }

    public void CreateEventClick(View view)
    {
        Toast not_available = Toast.makeText(this, "Not available yet", Toast.LENGTH_LONG);
        not_available.show();
    }
}