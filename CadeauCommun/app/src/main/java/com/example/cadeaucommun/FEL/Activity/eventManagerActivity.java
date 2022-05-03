package com.example.cadeaucommun.FEL.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cadeaucommun.DAL.ConcreteDAOs.EvenementDAO;
import com.example.cadeaucommun.FEL.Helpers.EventContext.EventAdapter;
import com.example.cadeaucommun.R;

public class eventManagerActivity extends AppCompatActivity {

    RecyclerView events;
    EventAdapter adapter;
    Button eventCreationButton;
    EvenementDAO dao = new EvenementDAO(this);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_manager);
        events = findViewById(R.id.allEvents_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        events.setLayoutManager(layoutManager);
        adapter = new EventAdapter(dao.findAll());
        events.setAdapter(adapter);

        eventCreationButton = findViewById(R.id.createEvent_btn);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void eventClick(View view)
    {
        Intent participants = new Intent(this, participantSelectionActivity.class);
        startActivity(participants);
    }

    public void CreateEventClick(View view)
    {
        Intent participants = new Intent(this, newEventActivity.class);
        startActivity(participants);
    }
}