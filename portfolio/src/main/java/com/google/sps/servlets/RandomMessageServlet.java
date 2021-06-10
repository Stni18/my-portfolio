package com.google.sps.servlets;

import java.util.ArrayList;


public class RandomMessageServlet {

    private final ArrayList<String> randomMessage;

    public RandomMessageServlet(ArrayList<String> randomMessage) {
        this.randomMessage = randomMessage;
    }

}