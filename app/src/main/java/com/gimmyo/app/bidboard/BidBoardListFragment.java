package com.gimmyo.app.bidboard;

import com.gimmyo.app.R;
import com.gimmyo.app.databinding.MainBidboardBinding;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jonregalado on 10/30/17.
 */

public class BidBoardListFragment extends Fragment {
	
	private OnBidBoardItemSelected mListener;
	
	public static BidBoardListFragment newInstance() {
		return new BidBoardListFragment();
	}
	
	public void onAttach(Context context) {
		super.onAttach(context);
		
		if (context instanceof  OnBidBoardItemSelected) {
			mListener = (OnBidBoardItemSelected) context;
		} else {
			throw new ClassCastException(context.toString() + "must implement OnBidItemSelectedListener");
		}
		
		//network call for getting resources
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		
		final MainBidboardBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_bidboard, container, false);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
		View view = binding.getRoot();
		
		return view;
	}
	
	public interface OnBidBoardItemSelected {
		void OnBidBoardItemSelected(int imageResId, String name, String description, String url);
	}
	
	
}
