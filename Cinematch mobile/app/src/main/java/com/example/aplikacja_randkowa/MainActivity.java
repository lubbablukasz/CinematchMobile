package com.example.aplikacja_randkowa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button buttonOpenContacts;
    private Button buttonOpenPairs;

    private Button buttonOpenMap;
    private Button buttonOpenMeetings;

    Button buttonOpenStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", Context.MODE_PRIVATE);

        buttonOpenContacts = findViewById(R.id.buttonOpenContacts);
        buttonOpenPairs = findViewById(R.id.buttonOpenPairs);
        buttonOpenMap = findViewById(R.id.buttonOpenMap);
        buttonOpenStats = findViewById(R.id.buttonOpenStats);
        buttonOpenMeetings = findViewById(R.id.buttonOpenMeetings);
        Spinner languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.language_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                setLanguagePreference(selectedLanguage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        updateButtonTexts();

        buttonOpenContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactMain.class);
                startActivity(intent);
            }
        });

        buttonOpenPairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PairsActivity.class);
                startActivity(intent);
            }
        });

        buttonOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        buttonOpenMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MeetingsActivity.class);
                startActivity(intent);
            }
        });

        buttonOpenStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatsActivity.class);
                startActivity(intent);
            }
        });

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateButtonTexts() {
        String contactsButtonText = sharedPreferences.getString("contacts_button", getString(R.string.contacts_button));
        String pairsButtonText = sharedPreferences.getString("pairs_button", getString(R.string.pairs_button));

        buttonOpenContacts.setText(contactsButtonText);
        buttonOpenPairs.setText(pairsButtonText);
    }

    private void setLanguagePreference(String language) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (language) {
            case "English":
                editor.putString("contacts_button", getString(R.string.contacts_button));
                editor.putString("pairs_button", getString(R.string.pairs_button));
                break;
            case "Polish":
                editor.putString("contacts_button", getString(R.string.contacts_button_pl));
                editor.putString("pairs_button", getString(R.string.pairs_button_pl));
                break;
        }
        editor.apply();

        updateButtonTexts();
    }
}
