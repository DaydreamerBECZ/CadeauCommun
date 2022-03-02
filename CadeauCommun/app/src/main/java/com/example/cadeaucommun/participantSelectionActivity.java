package com.example.cadeaucommun;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cadeaucommun.BLL.Model.Participant;
import java.util.ArrayList;
import java.util.List;

public class participantSelectionActivity extends AppCompatActivity {
    List<Participant> participants = new ArrayList<>();
    List<String> participants_name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_selection);

        ListView listView = findViewById(R.id.allParticipantsListView);

        Participant p = new Participant("Mark");
        participants.add(p);
        Participant p1 = new Participant("Zach");
        participants.add(p1);

        participants.stream().map(x -> participants_name.add(x.getName()));

        ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, participants_name);
        listView.setAdapter(adapter);
    }
}