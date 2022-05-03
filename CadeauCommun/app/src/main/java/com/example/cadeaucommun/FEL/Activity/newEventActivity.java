package com.example.cadeaucommun.FEL.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadeaucommun.BLL.Model.Evenement;
import com.example.cadeaucommun.DAL.ConcreteDAOs.EvenementDAO;
import com.example.cadeaucommun.R;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newEventActivity extends AppCompatActivity {
    TextView eventTitle, eventDescription, startDate, endDate;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        eventTitle = findViewById(R.id.eventTitle_lbl);
        eventDescription = findViewById(R.id.eventDesc_lbl);
        startDate = findViewById(R.id.eventStartDate_lbl);
        endDate = findViewById(R.id.eventEndDate_lbl);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setVisibility(View.INVISIBLE);
    }



    public void showStartCalendar(View view) {
        this.calendarView.bringToFront();
        this.calendarView.setVisibility(View.VISIBLE);
        this.startDate.callOnClick();
    }

    public void showEndCalendar(View view) {
        this.calendarView.bringToFront();
        this.calendarView.setVisibility(View.VISIBLE);
        this.endDate.callOnClick();
    }

    public void hideCalendar(View view) {
        if(this.calendarView.getVisibility() == View.VISIBLE)
            this.calendarView.setVisibility(View.INVISIBLE);
    }

    public void handleStartDate(View view) {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String date = day + "-" + (month + 1) + "-" + year;
                startDate.setText(date);
            }
        });

    }

    public void handleEndDate(View view) {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String date = day + "-" + (month + 1) + "-" + year;
                endDate.setText(date);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createEvent(View view) {
        EvenementDAO dao = new EvenementDAO(this);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        LocalDate start = LocalDate.parse(this.startDate.getText().toString(),formatter);
        LocalDate end = LocalDate.parse(this.endDate.getText().toString(),formatter);

        Evenement evenement = new Evenement();
        evenement.setTitle(this.eventTitle.getText().toString());
        evenement.setDescription(this.eventDescription.getText().toString());
        evenement.setBeginDate(start);
        evenement.setEndDate(end);

        dao.add(evenement);
        Toast.makeText(this,"Event was sucessfully created.", Toast.LENGTH_SHORT).show();
    }
}