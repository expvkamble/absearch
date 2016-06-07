package service;

import model.activity.ActivityReponse;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by vkamble on 6/7/16.
 */
public interface GoogleDistancematrix {
    @GET("/json")
    public ActivityReponse getActivities(@Query("origins") String origins,
                                         @Query("destinations") String destinations,
                                         @Query("mode") String mode,
                                         @Query("key") String key);
}
