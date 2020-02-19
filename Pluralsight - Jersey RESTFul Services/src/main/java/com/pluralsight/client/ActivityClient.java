package com.pluralsight.client;

import com.pluralsight.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ActivityClient {

    private Client client;

    public ActivityClient() {
        client = ClientBuilder.newClient();
    }

    public Activity get(String id) {
        WebTarget target = client.target("http://localhost:8080/webapi/");

        //Activity response = target.path("activities/" + id).request().get(Activity.class);

        String response = target.path("activities/" + id).request().get(String.class);

        System.out.println(response);

        return null;
    }

}
