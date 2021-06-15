
package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;


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

        //new variables
        long timestamp = System.currentTimeMillis();
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");


    FullEntity formEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", nameValue)
            .set("email", emailValue)
            .set("subject", subjectValue)
            .set("text-input", commentValue)
            .set("timestamp", timestamp)
            .build();
            datastore.put(formEntity);



        // Print the value so you can see it in the server logs.
        System.out.println("Name: " + nameValue);
        System.out.println("Email: " + emailValue);
        System.out.println("subject: " + subjectValue);
        System.out.println("Comments: " + commentValue);

        response.sendRedirect("/contact.html");

        /*
        // Write the value to the response so the user can see it.
        response.getWriter().println("Name: " + nameValue);
        response.getWriter().println("Email: " + emailValue);
        response.getWriter().println("Subject: " + subjectValue);
        response.getWriter().println("Comments: " + commentValue);
        */
    }

}
