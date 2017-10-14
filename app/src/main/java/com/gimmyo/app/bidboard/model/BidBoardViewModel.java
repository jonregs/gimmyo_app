package com.gimmyo.app.bidboard.model;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Jon on 9/30/2017.
 */

public class BidBoardViewModel extends BaseObservable{

    private BidItem mBidItem;
    private Context mContext;

    public BidBoardViewModel(BidItem bidItem, Context context) {
        mBidItem = bidItem;
        mContext = context;
    }

    public String getBidOfferId() {
        return mBidItem.getBidOfferId();
    }

    public String getBidOfferImage() {
        return mBidItem.getBidOfferImage();
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).centerCrop().into(view);
    }
}
