package com.google.sps.servlets;


public class ReturnRandomNumberServlet {

    protected final int Max_value = 3;
    protected final int Min_value = 0;
    int random = 0;

    public ReturnRandomNumberServlet() {

        random = ((int) (Math.random() * (Max_value - Min_value + 1))) + Min_value;

    }

}