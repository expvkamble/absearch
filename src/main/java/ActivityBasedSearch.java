/**
 * Created by vkamble on 6/6/16.
 */

import model.activity.Activity;
import model.activity.ActivityReponse;
import model.googledistancematrix.DistanceAndDuration;
import model.googledistancematrix.GoogleDistanceMatrixResponse;
import model.googledistancematrix.Row;
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
import java.util.Collections;
import java.util.Comparator;

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

        ArrayList<Activity> tempResult = activityReponse.getActivities();

        ArrayList<Activity> result = new ArrayList<Activity>();

        for (Activity activity : tempResult) {

            boolean skipThisActivity = false;
            for(String  category: activity.getCategories()) {
               if(category.contains("Transfers")) {
                   skipThisActivity = true;
                   break;
               }
            }

            if(!skipThisActivity) {
                result.add(activity);
            }
        }


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
        HotelSearchResult hotelSearchResult = hotelSearch.getHotels(destination1,checkInDate,checkOutDate,"2","15","TWrdB4AgBIs6Y6rBoF2HNMPwF42PQl4H");


        ArrayList<Hotel> hotels = hotelSearchResult.getHotelList();

        String hotelLatLongList= "";

        for(Hotel hotel: hotels) {

            hotelLatLongList = hotelLatLongList+hotel.getLatitude()+","+hotel.getLongitude()+"|";
            hotel.addShopUrl();
            hotel.addMapUrl(activitieslatlongList);
        }


        // vaibhav's key
        GoogleDistanceMatrixResponse googleDistanceMatrixResponse =  googleDistancematrix.getDistanceMatrix(hotelLatLongList,activitieslatlongList,"walking","AIzaSyDCKtP2VUzBweaAkueh9jQ0qbCa0aT_O2k");

        //Vishal's key
       // GoogleDistanceMatrixResponse googleDistanceMatrixResponse =  googleDistancematrix.getDistanceMatrix(hotelLatLongList,activitieslatlongList,"walking","AIzaSyBknuwqumRP-dWqTwrrGFoantCJKkFAM5s");


        ArrayList<Row> rows  = googleDistanceMatrixResponse.getRows();

        int numberOfHotels= hotels.size();
        long minSqaueSum = 0;
        long maxSqaueSum = 0;

        for(int i = 0 ; i < numberOfHotels; i++) {

            Hotel hotel = hotels.get(i);
            Row row = rows.get(i);

            long sm = hotel.addWalkSumSquare(row);

            if (sm > maxSqaueSum) {
                maxSqaueSum = sm;
            }
            if (sm < minSqaueSum ) {
                minSqaueSum = sm;
            }
        }

        for(Hotel hotel: hotels) {

            hotel.addWalkScore(minSqaueSum,maxSqaueSum);
        }

        Collections.sort(hotels, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                if(o1.getScroeInDouble() < o2.getScroeInDouble()) {
                    return 1;
                } else  {
                    return -1;
                }
            }
        });



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
