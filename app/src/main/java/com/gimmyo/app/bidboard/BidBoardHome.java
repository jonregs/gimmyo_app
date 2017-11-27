package com.gimmyo.app.bidboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.gimmyo.app.R;
import com.gimmyo.app.bidboard.adapter.BidItemAdapter;
import com.gimmyo.app.bidboard.model.BidItem;
import com.gimmyo.app.bidboard.model.BidItemResponse;
import com.gimmyo.app.databinding.MainBidboardBinding;
import com.gimmyo.app.rest.ApiClient;
import com.gimmyo.app.rest.ApiInterface;
import com.google.gson.GsonBuilder;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jon on 9/29/2017.
 */

public class BidBoardHome extends AppCompatActivity implements BidBoardListFragment.OnBidBoardItemSelected {

    String TAG = "BidBoard";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainBidboardBinding binding = DataBindingUtil.setContentView(this, R.layout.main_bidboard);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.mainBidboard.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        floatingActionSetup();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<BidItemResponse> call = apiService.getBidItems();
        call.enqueue(new Callback<BidItemResponse>() {
            @Override
            public void onResponse(Call<BidItemResponse> call, Response<BidItemResponse> response) {
                int statusCode = response.code();
                List<BidItem> bidItems = response.body().getResults();
                Log.i(TAG, "onResponse: " + new GsonBuilder().setPrettyPrinting().create().toJson(bidItems));

                BidItemAdapter adapter = new BidItemAdapter(bidItems, BidBoardHome.this);
                binding.mainBidboard.setAdapter(adapter);
//                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<BidItemResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    private void floatingActionSetup() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    
    @Override
    public void OnBidBoardItemSelected(int imageResId, String name, String description, String url) {
        final BidBoardDetailsFragment detailsFragment = BidBoardDetailsFragment.newInstance(imageResId, name, description, url);
//        getSupportFragmentManager().beginTransaction().replace()
    }
}
