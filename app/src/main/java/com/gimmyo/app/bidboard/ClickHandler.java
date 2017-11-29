package com.gimmyo.app.bidboard;

import android.util.Log;
import android.view.View;

/**
 * Created by jonregalado on 11/28/17.
 */

public class ClickHandler{
	
	final int imageResId;
	final String names;
	final String description;
	final String url;
	
	private BidBoardListFragment.OnBidBoardItemSelected onBidBoardItemSelected;
	String TAG = "TAG";
	
	public ClickHandler(int imageResId, String names, String description, String url) {
		this.imageResId = imageResId;
		this.names = names;
		this.description = description;
		this.url = url;
	}
	
	
	public View.OnClickListener onClickBid() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick: ");
				onBidBoardItemSelected = (BidBoardListFragment.OnBidBoardItemSelected) v.getContext();
				onBidBoardItemSelected.OnBidBoardItemSelected(imageResId, names, description, url);
			}
		};
	}
}
