package com.example.cadeaucommun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cadeaucommun.BLL.Model.Participant;

import java.util.ArrayList;

public class giftingActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifting);
        listView = findViewById(R.id.selectedParticipants);

    }
}