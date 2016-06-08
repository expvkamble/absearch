package model.hotelsearch;

import model.googledistancematrix.DistanceAndDuration;
import model.googledistancematrix.Row;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by vkamble on 6/7/16.
 */
public class Hotel {

    String hotelId;
    String name;
    String localizedName;
    String address;
    String city;
    String stateProvinceCode;
    String countryCode;
    String postalCode;
    String hotelStarRating;
    String hotelGuestRating;
    String shortDescription;
    String lowRate;
    String latitude;
    String longitude;

    String largeThumbnailUrl;
    String thumbnailUrl;
    String shopUrl;

    String mapUrl;

    String walkScore;

    double scroeInDouble;

    long squarSum;

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getWalkScore() {
        return walkScore;
    }

    public void setWalkScore(String walkScore) {
        this.walkScore = walkScore;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    String rateCurrencyCode;

    public long getSquarSum() {
        return squarSum;
    }

    public void setSquarSum(long squarSum) {
        this.squarSum = squarSum;
    }

    public String getRateCurrencyCode() {
        return rateCurrencyCode;
    }

    public void setRateCurrencyCode(String rateCurrencyCode) {
        this.rateCurrencyCode = rateCurrencyCode;
    }

    public String getLargeThumbnailUrl() {
        return largeThumbnailUrl;
    }

    public void setLargeThumbnailUrl(String largeThumbnailUrl) {
        this.largeThumbnailUrl = largeThumbnailUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHotelStarRating() {
        return hotelStarRating;
    }

    public void setHotelStarRating(String hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    public String getHotelGuestRating() {
        return hotelGuestRating;
    }

    public void setHotelGuestRating(String hotelGuestRating) {
        this.hotelGuestRating = hotelGuestRating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLowRate() {
        return lowRate;
    }

    public void setLowRate(String lowRate) {
        this.lowRate = lowRate;
    }

    public void addShopUrl() {

        String shopUrl = "https://www.expedia.com/";
        shopUrl = shopUrl + localizedName+".h"+hotelId+".Hotel-Information";
        this.shopUrl = shopUrl;
    }

    public long addWalkSumSquare(Row row) {

        ArrayList<DistanceAndDuration> distanceAndDurations = row.getElements();

        long tempSquarSum = 0;
        for(DistanceAndDuration distanceAndDuration : distanceAndDurations) {
            long distanceToAttraction = Long.valueOf(distanceAndDuration.getDistance().getValue());
            tempSquarSum = tempSquarSum + distanceToAttraction;
        }

        this.squarSum = tempSquarSum;
        return this.squarSum;
    }

    public double getScroeInDouble() {
        return scroeInDouble;
    }

    public void setScroeInDouble(double scroeInDouble) {
        this.scroeInDouble = scroeInDouble;
    }

    public void addWalkScore(long min , long max) {

        double minSqrt = Math.sqrt(min);

        double diff = Math.sqrt(max) - minSqrt;
        double delta = Math.sqrt(this.squarSum) - minSqrt;

        double score = delta /diff;

        double  finalScore =  ( (1-score ) * 10);

        this.scroeInDouble = finalScore;
        this.walkScore = ""+scroeInDouble;


    }

    public void addMapUrl(String attactionLatLongUrl) {

        StringTokenizer st = new StringTokenizer(attactionLatLongUrl,"|");

        String url = "https://maps.googleapis.com/maps/api/staticmap?center="+latitude+","+longitude+"&zoom=13&size=600x300&maptype=roadmap&key=AIzaSyBknuwqumRP-dWqTwrrGFoantCJKkFAM5s&markers=color:red%7Clabel:H%7C";

        url = url + this.latitude +","+this.longitude;
        int i = 1;
        while (st.hasMoreTokens()) {
            String str2 = "&markers=color:blue%7Clabel:A"+i+"%7C"+st.nextToken();

            url = url + str2;
        }
        this.mapUrl = url;
    }

}
