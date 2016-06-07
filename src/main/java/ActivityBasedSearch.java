/**
 * Created by vkamble on 6/6/16.
 */

import model.activity.Activity;
import model.activity.ActivityReponse;
import model.googledistancematrix.GoogleDistanceMatrixResponse;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import retrofit.RestAdapter;
import service.Activities;
import service.GoogleDistancematrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@RestController
@EnableAutoConfiguration
public class ActivityBasedSearch {

    RestAdapter activitiesRestAdapter;
    RestAdapter googleDistanceMatrixRestAdapter;

    Activities activities;
    GoogleDistancematrix  googleDistancematrix;
    ActivityBasedSearch activityBasedSearch;

    @RequestMapping("/absearch/{destination}")
    ArrayList<Activity> getAllActivities(@PathVariable("destination") String destination) {

        ActivityReponse activityReponse = activities.getActivities(destination,"TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");

        ArrayList<Activity> result = activityReponse.getActivities();

        return result;

    }

    @RequestMapping("/absearch/getHotels/{activitieslatlongList}")
    ArrayList<Activity> getHotels(@PathVariable("activitieslatlongList") String activitieslatlongList) {

      //  ActivityReponse activityReponse = activities.getActivities(destination,"TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");

       // ArrayList<Activity> result = activityReponse.getActivities();

       // return result;

        System.out.println(" activitieslatlongList :"+activitieslatlongList);
        return null;

    }


    @RequestMapping("/absearch/getDistance/{hotelLatLongList}/{activitieslatlongList}")
    ArrayList<Activity> getDistanceMatrix(@PathVariable("hotelLatLongList") String hotelLatLongList,
                                          @PathVariable("activitieslatlongList") String activitieslatlongList) {

        System.out.println(" hotelLatLongList :"+ hotelLatLongList);

        System.out.println(" activitieslatlongList :"+ activitieslatlongList);

        GoogleDistanceMatrixResponse googleDistanceMatrixResponse =  googleDistancematrix.getDistanceMatrix(hotelLatLongList,activitieslatlongList,"driving","AIzaSyDCKtP2VUzBweaAkueh9jQ0qbCa0aT_O2k");

        return null;

    }


    ActivityBasedSearch() {
        activitiesRestAdapter = new RestAdapter.Builder()
                .setEndpoint("http://terminal2.expedia.com/x/activities/")
                .build();

        activities = activitiesRestAdapter.create(Activities.class);


        googleDistanceMatrixRestAdapter = new RestAdapter.Builder()
                .setEndpoint("https://maps.googleapis.com/maps/api/distancematrix/")
                .build();

        googleDistancematrix = googleDistanceMatrixRestAdapter.create(GoogleDistancematrix.class);

    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ActivityBasedSearch.class, args);


    }


    public static ArrayList<String> getActivities(String destination) {

        //StringBuilder sb = new StringBuilder(API_URL_1).append(query).append(API_KEY);
        String output = "";
        URL url = null;
        URL url1 = null;
        URL url2 = null;

        try {
               url1 = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=point_of_interest&key=AIzaSyCCvw_1ASiIIZ0jZDjvG9rnh1FecDojlwI");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            // Create instance of connection to the API URL
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Read response body from the stream returned by getInputStream()
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
            StringBuilder rep = new StringBuilder();
            // We will get the result in json format

            while ((output = br.readLine()) != null) {
               // System.out.println(output);
                rep.append("\n");
                rep.append(output);
            }

            output = rep.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.printf(" Output is "+output);


        return null;
    }
}
