package com.example.aplikacja_randkowa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MeetingsActivity extends AppCompatActivity {

    private static final String NO_MEETINGS_MSG = "You don't have any meetings planned";

    private final MeetingsService service = new MeetingsService();
    private LinearLayout meetingsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        meetingsLayout = findViewById(R.id.linearLayout2);
        printMeetings();
    }

    private void printMeetings() {
        meetingsLayout.removeAllViews();

        List<Meeting> meetings = service.getMeetings();
        if(meetings.isEmpty()) {
            TextView textView = new TextView(this);
            textView.setText(NO_MEETINGS_MSG);
            meetingsLayout.addView(textView);
            return;
        }

        meetings.forEach(meeting -> {
            TextView textView = new TextView(this);
            String text = "Meeting with " + meeting.getContactName() + " at location " + meeting.getMeetingLocation();
            textView.setText(text);
            meetingsLayout.addView(textView);
        });
    }
}
