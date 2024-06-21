package com.example.aplikacja_randkowa;

public class Message {
    private String message;
    private boolean sent;

    public Message(String message, boolean sent) {
        this.message = message;
        this.sent = sent;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return sent;
    }
}