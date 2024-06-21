// ChatActivity.java
package com.example.aplikacja_randkowa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private List<Message> messages;
    private MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        messages = new ArrayList<>();
        messages.add(new Message("Hello!", true));
        messages.add(new Message("Hi there!", false));

        messagesAdapter = new MessagesAdapter(messages);
        recyclerViewMessages.setAdapter(messagesAdapter);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String text = editTextMessage.getText().toString().trim();
        if (!text.isEmpty()) {
            messages.add(new Message(text, true));
            messagesAdapter.notifyItemInserted(messages.size() - 1);
            recyclerViewMessages.scrollToPosition(messages.size() - 1);
            editTextMessage.setText("");
        }
    }
}
