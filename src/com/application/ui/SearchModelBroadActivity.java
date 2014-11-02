package com.application.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.application.R;
import com.application.ui.adapters.ModelBroadPagerAdapter;
import com.application.ui.view.PagerSlidingTabStrip;

public class SearchModelBroadActivity extends SherlockFragmentActivity{

	public static final String TAG = SearchModelBroadActivity.class.getSimpleName();

	private ImageView mImageView;
	
	private ViewPager mPager;
	private PagerSlidingTabStrip mPagerSlidingTabStrp;
	private ViewPager.SimpleOnPageChangeListener ViewPagerListener;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_car_model_broad);
		initUi();
		setPagerSlidingTabStrip();
		setUiEventListener();
	}
	
	private void initUi(){
		mImageView = (ImageView)findViewById(R.id.imageview);
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerSlidingTabStrp = (PagerSlidingTabStrip) findViewById(R.id.pager_sliding_tab_strip);
	}
	private void setPagerSlidingTabStrip() {
		ModelBroadPagerAdapter viewpageradapter = new ModelBroadPagerAdapter(
				getSupportFragmentManager());
//		mPager.setOffscreenPageLimit(4);
		mPager.setOffscreenPageLimit(3);
		mPager.setAdapter(viewpageradapter);
		mPagerSlidingTabStrp.setShouldExpand(true);
		mPagerSlidingTabStrp.setViewPager(mPager);
		setViewPagerListener();
		mPagerSlidingTabStrp.setOnPageChangeListener(ViewPagerListener);
	}
	
	private void setUiEventListener(){
		mImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(SearchModelBroadActivity.this, ImageViewerActivity.class);
				startActivity(mIntent);
			}
		});
	}
	
	private void setViewPagerListener(){
		ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				// Find the ViewPager Position
			}
		};
	}
}
