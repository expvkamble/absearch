package model.activity;

import java.util.ArrayList;

/**
 * Created by vkamble on 6/6/16.
 */
public class Activity {

    String  id;
    String  title;
    String  imageUrl;
    String  largeImageURL;
    String  fromPrice;
    String  fromPriceLabel;
    String  fromOriginalPrice;
    String  fromOriginalPriceValue;
    String  duration;
    String  fromPriceTicketType;
    String  freeCancellation;
    String  discountPercentage;
    ArrayList<String> categories;
    String  latLng;
    String  redemptionType;
    String  supplierName;
    String  recommendationScore;
    String  discountType;
    String  shortDescription;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public void setFromPrice(String fromPrice) {
        this.fromPrice = fromPrice;
    }

    public void setFromPriceLabel(String fromPriceLabel) {
        this.fromPriceLabel = fromPriceLabel;
    }

    public void setFromOriginalPrice(String fromOriginalPrice) {
        this.fromOriginalPrice = fromOriginalPrice;
    }

    public void setFromOriginalPriceValue(String fromOriginalPriceValue) {
        this.fromOriginalPriceValue = fromOriginalPriceValue;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setFromPriceTicketType(String fromPriceTicketType) {
        this.fromPriceTicketType = fromPriceTicketType;
    }

    public void setFreeCancellation(String freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng;
    }

    public void setRedemptionType(String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setRecommendationScore(String recommendationScore) {
        this.recommendationScore = recommendationScore;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getFromPrice() {
        return fromPrice;
    }

    public String getFromPriceLabel() {
        return fromPriceLabel;
    }

    public String getFromOriginalPrice() {
        return fromOriginalPrice;
    }

    public String getFromOriginalPriceValue() {
        return fromOriginalPriceValue;
    }

    public String getDuration() {
        return duration;
    }

    public String getFromPriceTicketType() {
        return fromPriceTicketType;
    }

    public String getFreeCancellation() {
        return freeCancellation;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public String getLatLng() {
        return latLng;
    }

    public String getRedemptionType() {
        return redemptionType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getRecommendationScore() {
        return recommendationScore;
    }

    public String getDiscountType() {
        return discountType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
