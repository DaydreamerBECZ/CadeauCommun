package com.example.cadeaucommun;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cadeaucommun.BLL.Model.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class participantSelectionActivity extends AppCompatActivity {
    List<Participant> participants = new ArrayList<>();
    List<String> participantsNames = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView; //= new ListView(this);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_selection);
        listView = (ListView) findViewById(R.id.allParticipantsListView);

        Participant p = new Participant("Mark", "hehe");
        participants.add(p);
        Participant p1 = new Participant("Zach", "hehe");
        participants.add(p1);

        participantsNames = participants.stream().map(x -> x.getName()).collect(Collectors.toList());

        adapter = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, participantsNames);
        listView.setAdapter(adapter);
    }
}