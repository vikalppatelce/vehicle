package com.application.ui;

import it.sephiroth.horizontallistview.HListView;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.application.R;
import com.application.ui.adapters.FuelTypeAdapter;
import com.application.ui.adapters.MakeAdapter;
import com.application.ui.view.ScrollableGridView;
import com.application.ui.view.VahanIndiaProgressDialog;
import com.balysv.materialmenu.MaterialMenuDrawable.IconState;
import com.balysv.materialmenu.MaterialMenuView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenListener;

public class SearchNewCarActivity extends BaseSliderActivity {

	private static String TAG = SearchNewCarActivity.class.getSimpleName();

	private SlidingMenu mSlideMenu;
	private ActionBar mActionBar;
	private HListView mHListView;
	private ScrollableGridView mGridView;
	private VahanIndiaProgressDialog mProgressDialog;
	private MaterialMenuView materialMenu;
	
	private ArrayList<String> mArrayListMakeType;
	private boolean[] mFuelType;

	private Button mSearchBtn;
	private TextView mTitle;
	
	private FuelTypeAdapter mHListViewAdapter;
	private MakeAdapter mGridViewAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_car_search);
		mSlideMenu = getSlidingMenu();
		mActionBar = getSupportActionBar();
		initSlideMenu();
		setCustomActionBar();
		initUi();
		initObj();
		setSlideMenuDrawerOpenCloseListener();
		mProgressDialog = new VahanIndiaProgressDialog(this);
		mProgressDialog.show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mProgressDialog.dismiss();
			}
		}, 5000);
		
		setUiEventListener();
		setAdapter();
	}

	private void setCustomActionBar() {
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);
		View mCustomView = mInflater.inflate(R.layout.actionbar_application,
				null);
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		materialMenu = (MaterialMenuView) mCustomView
				.findViewById(R.id.action_bar_menu);
		mTitle = (TextView)mCustomView.findViewById(R.id.action_bar_menu_title);
		mTitle.setText(getResources().getString(R.string.str_activity_search_new_car));
		setSlideMenuListener();
	}

	private void initUi() {
		mHListView = (HListView) findViewById(R.id.hlistview);
		mGridView = (ScrollableGridView)findViewById(R.id.activity_new_car_search_gridview);
		mSearchBtn = (Button)findViewById(R.id.search);
	}

	private void initObj(){
		mArrayListMakeType = new ArrayList<String>();
	}
	
	private void setAdapter() {
		mHListViewAdapter = new FuelTypeAdapter(SearchNewCarActivity.this);
		mGridViewAdapter = new MakeAdapter(SearchNewCarActivity.this, 15, false);
		mGridView.setExpanded(true);
		mHListView.setAdapter(mHListViewAdapter);
		mGridView.setAdapter(mGridViewAdapter);
	}

	private void setSlideMenuDrawerOpenCloseListener() {
		mSlideMenu.setOnOpenListener(new OnOpenListener() {
			@Override
			public void onOpen() {
				// TODO Auto-generated method stub
				materialMenu.animateState(IconState.ARROW);
				mTitle.setText(getResources().getString(R.string.app_name));
			}
		});

		mSlideMenu.setOnCloseListener(new OnCloseListener() {
			@Override
			public void onClose() {
				// TODO Auto-generated method stub
				materialMenu.animateState(IconState.BURGER);
				mTitle.setText(getResources().getString(R.string.str_activity_search_new_car));
			}
		});
	}
	
	private void setUiEventListener(){
		mSearchBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mArrayListMakeType.clear();
				mArrayListMakeType = mGridViewAdapter.getSelectedMake();
				mFuelType = mHListViewAdapter.getSelectedFuelType();
				
				Intent mIntent = new Intent(SearchNewCarActivity.this, SearchResultsActivity.class);
				startActivity(mIntent);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void initSlideMenu() {
	}

	private void setSlideMenuListener() {

		materialMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mSlideMenu.toggle();
			}
		});

	}

	public void toggleSlideMenuWithAnimation() {
		if (mSlideMenu.isMenuShowing()) {
			materialMenu.animateState(IconState.BURGER);
		} else {
			materialMenu.animateState(IconState.ARROW);
		}
		mSlideMenu.toggle();
	}
}
