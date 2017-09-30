package com.gimmyo.app.bidboard.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gimmyo.app.R;
import com.gimmyo.app.bidboard.model.BidBoardViewModel;
import com.gimmyo.app.bidboard.model.BidItem;
import com.gimmyo.app.databinding.ItemBidboardBinding;

import java.util.List;

/**
 * Created by Jon on 9/30/2017.
 */

public class BidItemAdapter extends RecyclerView.Adapter<BidItemAdapter.BindingHolder> {

    private List<BidItem> mBidItems;
    private Context mContext;

    public BidItemAdapter(List<BidItem> bidItems, Context context) {
        mBidItems = bidItems;
        mContext = context;
    }

    @Override
    public BidItemAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemBidboardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bidboard, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BidItemAdapter.BindingHolder holder, int position) {
        ItemBidboardBinding binding = holder.binding;
        binding.setBidItem(new BidBoardViewModel(mBidItems.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mBidItems.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {

        private ItemBidboardBinding binding;

        public BindingHolder(ItemBidboardBinding binding) {
            super(binding.bidOfferId);
            this.binding = binding;
        }
    }
}
