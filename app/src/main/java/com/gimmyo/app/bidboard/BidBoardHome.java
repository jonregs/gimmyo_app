package com.gimmyo.app.bidboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.gimmyo.app.R;

/**
 * Created by Jon on 9/29/2017.
 */

public class BidBoardHome extends AppCompatActivity implements BidBoardListFragment.OnBidBoardItemSelected {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, BidBoardListFragment.newInstance(), "bidBoardList")
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    
    @Override
    public void OnBidBoardItemSelected(int imageResId, String name, String description, String url) {
        Log.d("TAG", "OnBidBoardItemSelected: ");
        final BidBoardDetailsFragment detailsFragment =
                BidBoardDetailsFragment.newInstance(imageResId, name, description, url);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, detailsFragment, "bidBoardDetails")
                .commit();
    }
}
