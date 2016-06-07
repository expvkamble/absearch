/**
 * Created by vkamble on 6/6/16.
 */

import model.activity.Activity;
import model.activity.ActivityReponse;
import model.googledistancematrix.GoogleDistanceMatrixResponse;
import model.hotelsearch.Hotel;
import model.hotelsearch.HotelSearchResult;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import retrofit.RestAdapter;
import service.Activities;
import service.GoogleDistancematrix;
import service.HotelSearch;

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

    RestAdapter hotelSearchRestAdapter;
    HotelSearch hotelSearch;



    @RequestMapping("/absearch/{destination}")
    ArrayList<Activity> getAllActivities(@PathVariable("destination") String destination) {

        ActivityReponse activityReponse = activities.getActivities(destination,"TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");

        ArrayList<Activity> result = activityReponse.getActivities();

        System.out.println(" I am version 2.0");
        return result;

    }

    @RequestMapping("/absearch/gethotels/{destination1}")
    ArrayList<Hotel> getHotels(@PathVariable("destination1") String destination1,
                               @RequestParam("activitieslatlongList") String activitieslatlongList,
                               @RequestParam("checkInDate") String checkInDate,
                               @RequestParam("checkOutDate") String checkOutDate
                                   ) {

      //  ActivityReponse activityReponse = activities.getActivities(destination,"TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");

       // ArrayList<Activity> result = activityReponse.getActivities();

       // return result;

        System.out.println(" activitieslatlongList :"+activitieslatlongList);
        HotelSearchResult hotelSearchResult = hotelSearch.getHotels(destination1,checkInDate,checkOutDate,"2","TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");

        return hotelSearchResult.getHotelList();

    }


    @RequestMapping("/absearch/getDistance/{hotelLatLongList}")
    GoogleDistanceMatrixResponse getDistanceMatrix(@PathVariable("hotelLatLongList") String hotelLatLongList,
                                                   @RequestParam("activitieslatlongList") String activitieslatlongList) {


        System.out.println(" hotelLatLongList :"+ hotelLatLongList);

        System.out.println(" activitieslatlongList :"+ activitieslatlongList);

        GoogleDistanceMatrixResponse googleDistanceMatrixResponse =  googleDistancematrix.getDistanceMatrix(hotelLatLongList,activitieslatlongList,"walking","AIzaSyDCKtP2VUzBweaAkueh9jQ0qbCa0aT_O2k");

        return googleDistanceMatrixResponse;

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


        hotelSearchRestAdapter = new RestAdapter.Builder()
                .setEndpoint("http://terminal2.expedia.com/x/mhotels/")
                .build();
        hotelSearch = hotelSearchRestAdapter.create(HotelSearch.class);


    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ActivityBasedSearch.class, args);


    }
}
