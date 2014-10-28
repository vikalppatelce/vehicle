package com.application.ui.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.R;

public class MakeAdapter extends BaseAdapter {
	Context mContext;
	LayoutInflater mInflater;
	private int mSize;
	private int mTempSize = 9;
	private int mAllSize;
	private boolean mIsLoadAll = false;
	private ArrayList<String> mArrayListMake = new ArrayList<String>();
	private String TAG = MakeAdapter.class.getSimpleName();

	public MakeAdapter(Context mContext, int mSize, boolean mIsLoadAll) {
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		this.mIsLoadAll = mIsLoadAll;
		mAllSize = mSize;
		this.mSize = mTempSize;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mSize;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v;
		ViewHolder holder = null;

		if (convertView == null) {
			LayoutInflater li = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.item_gridview_new_car_search, null);
			holder = new ViewHolder();
			holder.mImageView = (ImageView) v
					.findViewById(R.id.item_gridview_new_car_search_iv);
			holder.mCheckBox = (ImageView) v
					.findViewById(R.id.item_gridview_new_car_search_cb);
			holder.mTextView = (TextView) v
					.findViewById(R.id.item_gridview_new_car_searc_tv);
			holder.mMoreLessTv = (TextView) v
					.findViewById(R.id.item_gridview_new_car_search_tv_more_less);
			holder.mView = (View) v
					.findViewById(R.id.item_gridview_new_car_search_v);
			holder.mFrameLayout = (FrameLayout) v
					.findViewById(R.id.item_gridview_new_car_search_fl);
			v.setTag(holder);
		} else {
			v = convertView;
			holder = (ViewHolder) v.getTag();
		}

		if (!mIsLoadAll) {
			if (position < 8) {
				Log.i(TAG, " " + position);
				holder.mFrameLayout.setVisibility(View.VISIBLE);
				holder.mMoreLessTv.setVisibility(View.GONE);
				holder.mTextView.setTextAppearance(mContext,
						R.style.AppTheme_TextView_Normal);

				setListener(holder.mFrameLayout, holder.mCheckBox,
						holder.mTextView, holder.mView, position);

			} else {
				if (position < 9) {
					Log.i(TAG, "More");
					holder.mFrameLayout.setVisibility(View.GONE);
					holder.mMoreLessTv.setVisibility(View.VISIBLE);
					holder.mMoreLessTv.setText("More");
					setMoreLessListener(holder.mMoreLessTv);
				}
			}
		} else {
			Log.i(TAG, " > 9 " + position);
			if (position < mSize - 1) {
				Log.i(TAG, " " + position);
				holder.mFrameLayout.setVisibility(View.VISIBLE);
				holder.mMoreLessTv.setVisibility(View.GONE);
				holder.mTextView.setTextAppearance(mContext,
						R.style.AppTheme_TextView_Normal);

				setListener(holder.mFrameLayout, holder.mCheckBox,
						holder.mTextView, holder.mView, position);

			} else {
				if (position < mSize) {
					Log.i(TAG, "More");
					holder.mFrameLayout.setVisibility(View.GONE);
					holder.mMoreLessTv.setVisibility(View.VISIBLE);
					holder.mMoreLessTv.setText("Less");
					setMoreLessListener(holder.mMoreLessTv);
				}
			}
		}

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

	public void setListener(FrameLayout mFrameLayout,
			final ImageView mCheckBox, final TextView mTextView,
			final View mView, final int position) {
		mFrameLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mArrayListMake.contains(mTextView.getText().toString())) {
					mTextView.setTextAppearance(mContext,
							R.style.AppTheme_TextView_Normal);
					mView.setBackgroundColor(Color.WHITE);
					mCheckBox.setImageResource(R.drawable.checkbox_unchecked);
					mArrayListMake.remove(mTextView.getText().toString());
				} else {
					mTextView.setTextAppearance(mContext,
							R.style.AppTheme_TextView_Bold);
					mView.setBackgroundColor(Color.BLACK);
					mCheckBox.setImageResource(R.drawable.checkbox_checked);
					mArrayListMake.add(mTextView.getText().toString());
				}
			}
		});
	}

	public void setMoreLessListener(final TextView mTextView) {
		mTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mTextView.getText().toString().equalsIgnoreCase("More")) {
					mIsLoadAll = true;
					mSize = mAllSize + 1;
					notifyDataSetChanged();
				} else {
					mIsLoadAll = false;
					mSize = mTempSize;
					notifyDataSetChanged();
				}
			}
		});

	}

	public ArrayList<String> getSelectedMake() {
		return mArrayListMake;
	}

	static class ViewHolder {
		ImageView mImageView, mCheckBox;
		FrameLayout mFrameLayout;
		TextView mTextView, mMoreLessTv;
		View mView;
	}
}