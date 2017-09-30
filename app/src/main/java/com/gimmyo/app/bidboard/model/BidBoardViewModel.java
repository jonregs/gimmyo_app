package com.gimmyo.app.bidboard.model;

import android.content.Context;
import android.databinding.BaseObservable;

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
}
