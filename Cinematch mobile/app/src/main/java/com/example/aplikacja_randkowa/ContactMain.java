package com.example.aplikacja_randkowa;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactMain extends AppCompatActivity {

    private RecyclerView recyclerViewContacts;
    private ContactsAdapter contactsAdapter;
    private List<Contact> contactList;
    private List<Contact> filteredContactList;
    private EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_main);

        editTextSearch = findViewById(R.id.editTextSearch);
        recyclerViewContacts = findViewById(R.id.recyclerViewContacts);
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this));

        contactList = getMockContacts();
        filteredContactList = new ArrayList<>(contactList);

        contactsAdapter = new ContactsAdapter(this, filteredContactList);
        recyclerViewContacts.setAdapter(contactsAdapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterContacts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void filterContacts(String query) {
        filteredContactList.clear();
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredContactList.add(contact);
            }
        }
        contactsAdapter.notifyDataSetChanged();
    }

    public List<Contact> getMockContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe"));
        contacts.add(new Contact("Jane Smith"));
        contacts.add(new Contact("Michael Johnson"));

        return contacts;
    }
}
