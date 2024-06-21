package com.example.aplikacja_randkowa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> persons;

    public PersonAdapter(Context context, List<Person> persons) {
        super(context, 0, persons);
        this.persons = persons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person person = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_card, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageViewPerson = convertView.findViewById(R.id.imageViewPerson);
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.textViewAge = convertView.findViewById(R.id.textViewAge);
            viewHolder.textViewGender = convertView.findViewById(R.id.textViewGender);
            viewHolder.textViewDescription = convertView.findViewById(R.id.textViewDescription);
            viewHolder.buttonLike = convertView.findViewById(R.id.buttonLike);
            viewHolder.buttonDecline = convertView.findViewById(R.id.buttonDecline);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set person's data
        //viewHolder.imageViewPerson.setImageResource(R.drawable.placeholder); // Update this with actual image loading logic
        viewHolder.textViewName.setText(person.getName());
        viewHolder.textViewAge.setText(String.valueOf(person.getAge()));
        viewHolder.textViewGender.setText(person.getGender());
        viewHolder.textViewDescription.setText(person.getDescription());

        // Set click listeners for buttons
        viewHolder.buttonLike.setOnClickListener(v -> {
            // Handle like action
            removePerson(position);
        });

        viewHolder.buttonDecline.setOnClickListener(v -> {
            // Handle decline action
            removePerson(position);
        });

        return convertView;
    }

    private void removePerson(int position) {
        persons.remove(position);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        ImageView imageViewPerson;
        TextView textViewName;
        TextView textViewAge;
        TextView textViewGender;
        TextView textViewDescription;
        Button buttonLike;
        Button buttonDecline;
    }
}
