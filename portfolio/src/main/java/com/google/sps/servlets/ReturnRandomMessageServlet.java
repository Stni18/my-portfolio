package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;

@WebServlet("/random")
public class ReturnRandomMessageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // objects
        Gson gson = new Gson(); // used to convert string to Json

        int random = 0;
        final int maxValue = 3;
        final int minValue = 0;

        // Create a string arraylist
        ArrayList<String> randomMessage = new ArrayList<String>();
        
        randomMessage.add("Greetings, hope you are doing well");
        randomMessage.add("I love JRPGs");
        randomMessage.add("I am well versed in Java");
        randomMessage.add("If you do not succeed  try, and try again");
        
        String crazyMessage = randomMessage.get(randomNumb());

        // should print the mesages in json format
        String jsonString = gson.toJson(crazyMessage);
        response.getWriter().println(jsonString);
    }


    private static int randomNumb() {

        int random = 0;
        final int maxValue = 3;
        final int minValue = 0;

        random = ((int) (Math.random() * (maxValue - minValue + 1))) + minValue;
        return random;
        
    }

}