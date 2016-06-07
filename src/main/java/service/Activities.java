package service;

import model.activity.ActivityReponse;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by vkamble on 6/6/16.
 */
public interface Activities {

    @GET("/search")
    public ActivityReponse getActivities(@Query("location") String location,
                                         @Query("apikey") String apikey);
}
