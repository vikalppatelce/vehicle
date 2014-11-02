package com.application.ui.adapters;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.application.R;
import com.application.ui.SearchModelBroadActivity;
import com.application.ui.SearchResultsActivity;
import com.application.ui.view.GPlusListAdapter;
import com.application.ui.view.SpeedScrollListener;

public class SearchResultAdapter extends GPlusListAdapter {
	Context mContext;
	LayoutInflater mInflater;
	List<? extends Object> items;
	private boolean[] mIsSelected = { false, false, false, false };
	private String TAG = SearchResultAdapter.class.getSimpleName();
	private int[] defaultIcon = { R.drawable.petrol, R.drawable.diesel,
			R.drawable.cng, R.drawable.electric };
	private int[] selectIcon = { R.drawable.petrol_tick,
			R.drawable.diesel_tick, R.drawable.cng_tick,
			R.drawable.electric_tick };

	public SearchResultAdapter(Context mContext, SpeedScrollListener scrollListener, List<? extends Object> items) {
	    super(mContext, scrollListener, items);
	    this.mContext = mContext;
	    this.items = items;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  }
	
	public void addItems(List<? extends Object> items){
		super.addItems(items);
		this.items = items;
	}
	
	static class ViewHolder {
		ImageView mImageView;
		LinearLayout mLinearLayout;
	}

	@Override
	protected View getRowView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v;
		ViewHolder holder = null;

		if (convertView == null) {
			LayoutInflater li = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.item_hlistview_new_car_search, null);
			holder = new ViewHolder();
			holder.mImageView = (ImageView) v
					.findViewById(R.id.item_hlistview_new_car_search_image);
			holder.mLinearLayout = (LinearLayout) v
					.findViewById(R.id.item_hlistview_new_car_search_layout);
			v.setTag(holder);
		} else {
			v = convertView;
			holder = (ViewHolder) v.getTag();
		}

		holder.mImageView.setImageResource(defaultIcon[position%4]);
		
		holder.mImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(mContext, SearchModelBroadActivity.class);
				mContext.startActivity(mIntent);
			}
		});
		return v;

	}
}