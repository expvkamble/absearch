package model.hotelsearch;

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
    String rateCurrencyCode;
    String largeThumbnailUrl;
    String thumbnailUrl;

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
}
