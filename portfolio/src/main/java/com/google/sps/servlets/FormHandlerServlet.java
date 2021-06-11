
package com.google.sps.servlets;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that processes text. */
@WebServlet("/form-handler")
public final class FormHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get the value entered in the form.
        String nameValue = request.getParameter("name");
        String emailValue = request.getParameter("email");
        String subjectValue = request.getParameter("subject");
        String commentValue = request.getParameter("text-input");

        // Print the value so you can see it in the server logs.
        System.out.println("Name: " + nameValue);
        System.out.println("Email: " + emailValue);
        System.out.println("subject: " + subjectValue);
        System.out.println("Comments: " + commentValue);

        // Write the value to the response so the user can see it.
        response.getWriter().println("Name: " + nameValue);
        response.getWriter().println("Email: " + emailValue);
        response.getWriter().println("Subject: " + subjectValue);
        response.getWriter().println("Comments: " + commentValue);

    }

}
