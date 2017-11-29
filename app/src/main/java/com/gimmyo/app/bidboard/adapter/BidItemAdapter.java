package com.gimmyo.app.bidboard.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gimmyo.app.R;
import com.gimmyo.app.bidboard.ClickHandler;
import com.gimmyo.app.bidboard.model.BidBoardViewModel;
import com.gimmyo.app.bidboard.model.BidItem;
import com.gimmyo.app.databinding.ItemBidboardBinding;
import java.util.List;

public class BidItemAdapter extends RecyclerView.Adapter<BidItemAdapter.BindingHolder> {
    
    private int[] mImageResIds;
    private String[] mNames;
    private String[] mDescriptions;
    private String[] mUrls;
    private List<BidItem> mBidItems;
    private Context mContext;

    public BidItemAdapter(List<BidItem> bidItems, Context context) {
        mBidItems = bidItems;
        mContext = context;
    
        // Get rage face names and descriptions.
        final Resources resources = context.getResources();
        mNames = resources.getStringArray(R.array.names);
        mDescriptions = resources.getStringArray(R.array.descriptions);
        mUrls = resources.getStringArray(R.array.urls);
    
        final TypedArray typedArray = resources.obtainTypedArray(R.array.images);
        final int imageCount = mNames.length;
        mImageResIds = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageResIds[i] = typedArray.getResourceId(i, 0);
        }
        typedArray.recycle();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemBidboardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bidboard, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BidItemAdapter.BindingHolder holder, int position) {
        final int imageResId = mImageResIds[position];
        final String names = mNames[position];
        final String description = mDescriptions[position];
        final String url = mUrls[position];
        
        ItemBidboardBinding binding = holder.binding;
        binding.setHandler(new ClickHandler(imageResId, names, description, url));
        binding.setBidItem(new BidBoardViewModel(mBidItems.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mBidItems.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {

        private ItemBidboardBinding binding;

        public BindingHolder(ItemBidboardBinding binding) {
            super(binding.bidCard);
            this.binding = binding;
        }
    }
}
