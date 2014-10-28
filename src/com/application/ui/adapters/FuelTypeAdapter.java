package com.application.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.application.R;

public class FuelTypeAdapter extends BaseAdapter {
	Context mContext;
	LayoutInflater mInflater;
	private boolean[] mIsSelected = { false, false, false, false };
	private String TAG = FuelTypeAdapter.class.getSimpleName();
	private int[] defaultIcon = { R.drawable.petrol, R.drawable.diesel,
			R.drawable.cng, R.drawable.electric };
	private int[] selectIcon = { R.drawable.petrol_tick,
			R.drawable.diesel_tick, R.drawable.cng_tick,
			R.drawable.electric_tick };

	public FuelTypeAdapter(Context mContext) {
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
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

		holder.mImageView.setImageResource(defaultIcon[position]);

		setListener(holder.mLinearLayout,holder.mImageView,position);

		return v;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setListener(LinearLayout mLinearLayout, final ImageView mImageView, final int position){
		mLinearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mIsSelected[position]){
					mImageView.setImageResource(defaultIcon[position]);
					mIsSelected[position] = false;
				}else{
					mImageView.setImageResource(selectIcon[position]);
					mIsSelected[position] = true;
				}
			}
		});
	}
	
	public boolean[] getSelectedFuelType(){
		return mIsSelected;
	}
	
	static class ViewHolder {
		ImageView mImageView;
		LinearLayout mLinearLayout;
	}
}