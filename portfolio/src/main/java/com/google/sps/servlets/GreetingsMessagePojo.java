package com.google.sps.servlets;

import java.util.ArrayList;


public class GreetingsMessagePojo {

    private final ArrayList<String> messages;

    public GreetingsMessagePojo(ArrayList<String> messages) {
        this.messages = messages;
    }

}