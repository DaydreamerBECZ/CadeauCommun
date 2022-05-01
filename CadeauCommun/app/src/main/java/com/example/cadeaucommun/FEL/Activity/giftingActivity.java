package com.example.cadeaucommun.FEL.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cadeaucommun.BLL.Model.ParticipantOld;
import com.example.cadeaucommun.FEL.Fragment.giftCreationFragment;
import com.example.cadeaucommun.FEL.Fragment.participantViewFragment;
import com.example.cadeaucommun.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class giftingActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    List<String> selectedParticipantsNames = new ArrayList<>();
    List<ParticipantOld> selectedParticipants = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifting);
        listView =  findViewById(R.id.selectedParticipantsListView);

        giftCreationFragment makeGiftFragment = new giftCreationFragment();
        participantViewFragment participantListViewFragment = new participantViewFragment();

        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.makeGiftFragmentFrameLayout, makeGiftFragment);
        transaction.add(R.id.participantListFragmentFrameLayout, participantListViewFragment);

        Bundle extra = this.getIntent().getBundleExtra("Participants Selected");

        //selectedParticipants = extra.getSerializable("Participants Selected");

        selectedParticipantsNames = selectedParticipants.stream().map(x -> x.getName()).collect(Collectors.toList());

        transaction.commit();
    }
}