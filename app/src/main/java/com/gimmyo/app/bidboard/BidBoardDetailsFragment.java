package com.gimmyo.app.bidboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jonregalado on 10/30/17.
 */

public class BidBoardDetailsFragment extends Fragment{
	
	private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
	private static final String ARGUMENT_NAME = "name";
	private static final String ARGUMENT_DESCRIPTION = "description";
	private static final String ARGUMENT_URL = "url";
	
	public static BidBoardDetailsFragment newInstance(int imageResId, String name, String description, String url) {
		
		final Bundle args = new Bundle();
		args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
		args.putString(ARGUMENT_NAME, name);
		args.putString(ARGUMENT_DESCRIPTION, description);
		args.putString(ARGUMENT_URL, url);
		final BidBoardDetailsFragment fragment = new BidBoardDetailsFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
