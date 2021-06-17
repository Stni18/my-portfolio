
package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.sps.data.Task;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;

import org.eclipse.jetty.util.thread.Scheduler.Task;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;



/** Servlet that processes text. */
@WebServlet("/load-form")
public final class LoadFormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        //used to load data
        Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Form").setOrderBy(OrderBy.desc("timestamp")).build();
        QueryResults<Entity> results = datastore.run(query);

    ArrayList<Object> forms = new ArrayList<>();

    while (results.hasNext()) {
      Entity entity = results.next();

      long id = entity.getKey().getId();
      String name = entity.getString("name");
      long timeStamp = entity.getLong("timestamp");
      String email = entity.getString("email");
      String subject = entity.getString("subject");
      String comment = entity.getString("text-input");

      String[] content = {name, " " + subject, " " + comment, "\n\n" };
              
    //   forms.add("\n" +  "/"+id);  //This works 
    //   forms.add( " " + "/"+name);
    //   forms.add(" " + "/"+ timeStamp);
    //   //forms.add(" " + email);
    //   forms.add(" "+ "/"+ subject);
    //   forms.add(" " + "/"+ comment + "\n\n");

        forms.add(content);

    }

    Gson gson = new Gson();

    response.setContentType("application/json");
    response.getWriter().println(gson.toJson(forms));
   
    }
}
