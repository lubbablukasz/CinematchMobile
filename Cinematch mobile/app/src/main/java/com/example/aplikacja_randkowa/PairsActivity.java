package com.example.aplikacja_randkowa;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PairsActivity extends AppCompatActivity {

    private List<Person> persons;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairs);

        // Initialize persons list (example data)
        persons = new ArrayList<>();
        persons.add(new Person("John Doe", 25, "Male", "Likes hiking and reading books."));
        persons.add(new Person("Jane Smith", 22, "Female", "Enjoys painting and playing guitar."));
        persons.add(new Person("Alex Johnson", 30, "Non-binary", "Avid traveler and food lover."));
        persons.add(new Person("Emily Davis", 28, "Female", "Passionate about yoga and cooking."));
        persons.add(new Person("Michael Brown", 35, "Male", "Enjoys photography and cycling."));
        persons.add(new Person("Sarah Wilson", 27, "Female", "Loves dancing and playing tennis."));
        persons.add(new Person("Chris Martinez", 32, "Male", "Tech enthusiast and gamer."));
        persons.add(new Person("Ashley Taylor", 26, "Female", "Interested in fashion and design."));
        persons.add(new Person("Ryan Moore", 29, "Male", "Fitness freak and marathon runner."));
        persons.add(new Person("Olivia Anderson", 24, "Female", "Musician and nature lover."));
        persons.add(new Person("Daniel Thomas", 31, "Male", "History buff and bookworm."));
        persons.add(new Person("Jessica White", 23, "Female", "Digital artist and pet lover."));
        persons.add(new Person("Matthew Harris", 33, "Male", "Entrepreneur and investor."));
        persons.add(new Person("Laura Martin", 25, "Female", "Biologist and scuba diver."));
        persons.add(new Person("David Lee", 28, "Male", "Photographer and traveler."));
        persons.add(new Person("Sophia Clark", 27, "Female", "Chef and food blogger."));
        persons.add(new Person("James Rodriguez", 34, "Male", "Engineer and robotics hobbyist."));
        persons.add(new Person("Isabella Lewis", 22, "Female", "Dancer and choreographer."));
        persons.add(new Person("Joshua Walker", 29, "Male", "Mountain climber and nature explorer."));
        persons.add(new Person("Ava Hall", 26, "Female", "Writer and poet."));
        // Add more persons as needed

        // Create adapter
        adapter = new PersonAdapter(this, persons);

        // Find the ListView
        ListView listView = findViewById(R.id.listViewCards);

        // Set adapter to the ListView
        listView.setAdapter(adapter);
    }
}
