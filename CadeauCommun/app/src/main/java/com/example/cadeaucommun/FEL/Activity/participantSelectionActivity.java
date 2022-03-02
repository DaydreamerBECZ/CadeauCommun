package com.example.cadeaucommun.FEL.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cadeaucommun.BLL.Model.Participant;
import com.example.cadeaucommun.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class participantSelectionActivity extends AppCompatActivity {
    List<Participant> participants = new ArrayList<>();
    List<String> participantsNames = new ArrayList<>();
    ArrayList<Participant> selected = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_selection);

        //1. gets all participants and adds them to the list view.
        listView =  findViewById(R.id.allParticipantsListView);

        //participant objects for test, eventually will be DAO call to get all participants from db.
        Participant p = new Participant("Mark", "Awad", "pic.jpeg");
        participants.add(p);
        Participant p1 = new Participant("Zachary", "Bechard", "pic.jpeg");
        participants.add(p1);
        Participant p2 = new Participant("Shady", "Guindi", "pic.jpeg");
        participants.add(p2);
        Participant p3 = new Participant("Yssa", "Metry", "pic.jpeg");
        participants.add(p3);
        Participant p4 = new Participant("Ioann", "Robert", "pic.jpeg");
        participants.add(p4);

        participantsNames = participants.stream().map(x -> x.getName()).collect(Collectors.toList()); //transform each element into a usable list for displaying

        //displays the Participant object instance by full name.
        adapter = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, participantsNames);
        listView.setAdapter(adapter);
        //end of 1.

        //2. collection of all wanted participants
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //animate to keep selection
                adapter.getView(i,view, adapterView).setBackgroundColor(Color.parseColor("#d1d1d1"));

                //making sure that obj is only added once
                if(selected.contains(participants.get(i))){
                    Toast.makeText(participantSelectionActivity.this, participantsNames.get(i) + " has already been selected.", Toast.LENGTH_SHORT).show();
                }else{
                    //track all selected
                    Toast.makeText(participantSelectionActivity.this, participantsNames.get(i) + " has been selected.", Toast.LENGTH_SHORT).show();
                    selected.add(participants.get(i));
                    Log.d("Item Selected is", selected.toString());
                }
            }
        });

        //removes selected item if long clicked
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.getView(i,view, adapterView).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                selected.remove(participants.get(i));
                Log.d("Item removed is", selected.toString());
                return true;
            }
        });
        //end of 2.
    }

    //3. send the selected list to the next activity
    public void applyParticipants(View view) {
        Intent intent = new Intent(this, giftingActivity.class);
        Object[] participants = selected.toArray();
        intent.putExtra("Participants Selected", participants);
        startActivity(intent);
    }
}