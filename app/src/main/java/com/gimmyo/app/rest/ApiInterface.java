package com.gimmyo.app.rest;

import com.gimmyo.app.bidboard.model.BidItem;
import com.gimmyo.app.bidboard.model.BidItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jon on 9/29/2017.
 */

public interface ApiInterface {

    @GET("bids")
    Call<BidItemResponse> getBidItems();

//    @GET("profile")
//    Call<BidItem> profileInfo();

}
