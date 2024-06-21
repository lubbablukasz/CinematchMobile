package com.example.aplikacja_randkowa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// MessagesAdapter.java
public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SENT = 1;
    private static final int VIEW_TYPE_RECEIVED = 2;

    private List<Message> messages;

    public MessagesAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        return message.isSent() ? VIEW_TYPE_SENT : VIEW_TYPE_RECEIVED;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case VIEW_TYPE_SENT:
                view = inflater.inflate(R.layout.item_messages_sent, parent, false);
                return new SentMessageViewHolder(view);
            case VIEW_TYPE_RECEIVED:
                view = inflater.inflate(R.layout.item_message_received, parent, false);
                return new ReceivedMessageViewHolder(view);
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_SENT:
                SentMessageViewHolder sentViewHolder = (SentMessageViewHolder) holder;
                sentViewHolder.bind(message);
                break;
            case VIEW_TYPE_RECEIVED:
                ReceivedMessageViewHolder receivedViewHolder = (ReceivedMessageViewHolder) holder;
                receivedViewHolder.bind(message);
                break;
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // ViewHolder for sent messages
    private static class SentMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessageBody;

        SentMessageViewHolder(View itemView) {
            super(itemView);
            textMessageBody = itemView.findViewById(R.id.text_message_body);  // Update with correct ID
        }

        void bind(Message message) {
            textMessageBody.setText(message.getMessage());
            // Additional binding logic if needed
        }
    }

    // ViewHolder for received messages
    private static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessageBody;

        ReceivedMessageViewHolder(View itemView) {
            super(itemView);
            textMessageBody = itemView.findViewById(R.id.text_message_body);  // Update with correct ID
        }

        void bind(Message message) {
            textMessageBody.setText(message.getMessage());
            // Additional binding logic if needed
        }
    }
}
