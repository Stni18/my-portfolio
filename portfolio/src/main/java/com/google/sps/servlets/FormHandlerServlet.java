
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
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;


/** Servlet that processes text. */
@WebServlet("/form-handler")
public final class FormHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get the value entered in the form.
        String nameValue = Jsoup.clean(request.getParameter("name"), Whitelist.none());
        String emailValue = Jsoup.clean(request.getParameter("email"), Whitelist.none());
        String subjectValue = Jsoup.clean(request.getParameter("subject"), Whitelist.none());
        String commentValue = Jsoup.clean(request.getParameter("text-input"), Whitelist.none());

        //new variables
        long timestamp = System.currentTimeMillis();
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");

        //used to store data
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

        //response.sendRedirect("/contact.html"); may change to loadForm.html
        response.sendRedirect("/loadForm.html");
        
    }
}