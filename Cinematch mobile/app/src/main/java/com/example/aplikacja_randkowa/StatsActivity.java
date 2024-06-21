package com.example.aplikacja_randkowa;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;

import java.util.stream.Collectors;

public class StatsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TextView textViewTotalMatches = findViewById(R.id.textViewTotalMatches);
        TextView textViewRejected = findViewById(R.id.textViewRejected);
        TextView textViewAccepted = findViewById(R.id.textViewAccepted);
        TextView textViewMessagesSent = findViewById(R.id.textViewMessagesSent);
        TextView textViewMeetingsConfirmed = findViewById(R.id.textViewMeetingsConfirmed);

        textViewTotalMatches.setText("All pairs: " + 3);
        textViewRejected.setText("Declined pairs: " + 3);
        textViewAccepted.setText("Accepted pairs: " + 1);
        textViewMessagesSent.setText("Messages sent: " + 6);
        textViewMeetingsConfirmed.setText("Meetings confirmed: " + 0);

    }
}
