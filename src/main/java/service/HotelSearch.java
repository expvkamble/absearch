package service;

import model.googledistancematrix.GoogleDistanceMatrixResponse;
import model.hotelsearch.HotelSearchResult;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by vkamble on 6/7/16.
 */
public interface HotelSearch {

    @GET("/search")
    public HotelSearchResult getHotels(@Query("city") String city,
                                               @Query("checkInDate") String checkInDate,
                                               @Query("checkOutDate") String checkOutDate,
                                               @Query("room1") String room1,
                                                @Query("resultsPerPage") String resultsPerPage,
                                                @Query("apikey") String apikey);
}
