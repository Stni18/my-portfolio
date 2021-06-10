package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * Handles requests sent to the /hello URL. Try running a server and navigating
 * to /hello!
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        
        // Create a string arraylist
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Greetings, hope you are doing well");
        messages.add("I love JRPG's");
        messages.add("I am well versed in Java");
        messages.add("If you do not succeed  try, and try again");

        

        //create objects
        ReturnRandomNumberServlet wild = new ReturnRandomNumberServlet();
        Gson gson = new Gson(); //used to convert string to Json

        ArrayList<String> randomMessage = new ArrayList<String>();
        randomMessage.add(messages.get(wild.random));

        RandomMessageServlet random = new RandomMessageServlet(randomMessage); //obtains random strings

        
       //should print the mesages in json format
        String jsonString = gson.toJson(random);
        response.getWriter().println(jsonString);
    }


}
