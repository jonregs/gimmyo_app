package com.gimmyo.app.bidboard;

import com.gimmyo.app.R;
import com.gimmyo.app.bidboard.adapter.BidItemAdapter;
import com.gimmyo.app.bidboard.model.BidItem;
import com.gimmyo.app.bidboard.model.BidItemResponse;
import com.gimmyo.app.databinding.MainBidboardBinding;
import com.gimmyo.app.rest.ApiClient;
import com.gimmyo.app.rest.ApiInterface;
import com.google.gson.GsonBuilder;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by jonregalado on 11/26/17.
 */

public class BidBoardListFragment extends Fragment {
	
	String TAG = "BidBoard";
	BidItemAdapter bidItemAdapter;
//	private OnBidBoardItemSelected bidBoardItemSelected;
	
	public static BidBoardListFragment newInstance() {
		return new BidBoardListFragment();
	}
	
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		
//		if(context instanceof OnBidBoardItemSelected) {
//			bidBoardItemSelected = (OnBidBoardItemSelected) context;
//		} else {
//			throw new ClassCastException(context.toString() + " must implement OnBidItemSelected");
//		}
		
		ApiInterface apiService =
				ApiClient.getClient().create(ApiInterface.class);

		Call<BidItemResponse> call = apiService.getBidItems();
		call.enqueue(new Callback<BidItemResponse>() {
			@Override
			public void onResponse(Call<BidItemResponse> call, Response<BidItemResponse> response) {
				int statusCode = response.code();
				List<BidItem> bidItems = response.body().getResults();
				Log.i(TAG, "onResponse: " + new GsonBuilder().setPrettyPrinting().create().toJson(bidItems));

				bidItemAdapter = new BidItemAdapter(bidItems, getActivity());
				final RecyclerView recyclerView = getView().findViewById(R.id.main_bidboard);
				
				recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
				recyclerView.setItemAnimator(new DefaultItemAnimator());
				recyclerView.setAdapter(bidItemAdapter);
			}

			@Override
			public void onFailure(Call<BidItemResponse> call, Throwable t) {
				// Log error here since request failed
				Log.e(TAG, t.toString());
			}
		});
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "inside onCreateView: ");
		return DataBindingUtil.inflate(inflater, R.layout.main_bidboard, container, false).getRoot();
	}
	
	public interface OnBidBoardItemSelected {
		void OnBidBoardItemSelected(int imageResId, String name, String description, String url);
	}
}
