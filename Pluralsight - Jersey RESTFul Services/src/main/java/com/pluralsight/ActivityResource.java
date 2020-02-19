package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("activities") // http://localhost:8080/webapi/activities
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        activityRepository.create(activity);
        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.create(activity);

        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));
        return activity;
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}") // http://localhost:8080/webapi/activities/<activityId>
    public Activity getActivity(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user") // http://localhost:8080/webapi/activities/<activityId>/user
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
    }

}
