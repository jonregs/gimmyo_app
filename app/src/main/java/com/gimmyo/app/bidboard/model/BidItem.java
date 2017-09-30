package com.gimmyo.app.bidboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jon on 9/29/2017.
 */

public class BidItem {

    @SerializedName("bidOfferId")
    private String bidOfferId;
    @SerializedName("carManufacturer")
    private String carManufacturer;
    @SerializedName("carModel")
    private String carModel;
    @SerializedName("carYear")
    private String carYear;
    @SerializedName("bidOfferImage")
    private String bidOfferImage;
    @SerializedName("bidAmount")
    private double bidAmount;
    @SerializedName("targetUri")
    private String targetUri;
    @SerializedName("likes")
    private int likes;
    @SerializedName("dealerOffers")
    private int dealerOffers;

    public BidItem(String bidOfferId, String carManufacturer, String carModel, String carYear, String bidOfferImage, double bidAmount, String targetUri, int likes, int dealerOffers) {
        this.bidOfferId = bidOfferId;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carYear = carYear;
        this.bidOfferImage = bidOfferImage;
        this.bidAmount = bidAmount;
        this.targetUri = targetUri;
        this.likes = likes;
        this.dealerOffers = dealerOffers;
    }

    public String getBidOfferId() {
        return bidOfferId;
    }

    public void setBidOfferId(String bidOfferId) {
        this.bidOfferId = bidOfferId;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getBidOfferImage() {
        return bidOfferImage;
    }

    public void setBidOfferImage(String bidOfferImage) {
        this.bidOfferImage = bidOfferImage;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDealerOffers() {
        return dealerOffers;
    }

    public void setDealerOffers(int dealerOffers) {
        this.dealerOffers = dealerOffers;
    }
}
