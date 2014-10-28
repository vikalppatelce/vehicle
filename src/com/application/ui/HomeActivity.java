package com.application.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.application.R;
import com.application.ui.view.VahanIndiaProgressDialog;
import com.balysv.materialmenu.MaterialMenuDrawable.IconState;
import com.balysv.materialmenu.MaterialMenuView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenListener;

public class HomeActivity extends BaseSliderActivity {

	private static String TAG = HomeActivity.class.getSimpleName();

	private TextView mSlideMenuTxt;
	private SlidingMenu mSlideMenu;
	private ActionBar mActionBar;
	private VahanIndiaProgressDialog mProgressDialog;
	private MaterialMenuView materialMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSlideMenu = getSlidingMenu();
		mActionBar = getSupportActionBar();
		initSlideMenu();
		setCustomActionBar();
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
	}

	private void setCustomActionBar() {
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);
		View mCustomView = mInflater.inflate(R.layout.actionbar_application, null);
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		materialMenu = (MaterialMenuView) mCustomView.findViewById(R.id.action_bar_menu);
		setSlideMenuListener();
	}

	private void setSlideMenuDrawerOpenCloseListener() {
		mSlideMenu.setOnOpenListener(new OnOpenListener() {
			@Override
			public void onOpen() {
				// TODO Auto-generated method stub
				materialMenu.animateState(IconState.ARROW);
			}
		});

		mSlideMenu.setOnCloseListener(new OnCloseListener() {
			@Override
			public void onClose() {
				// TODO Auto-generated method stub
				materialMenu.animateState(IconState.BURGER);
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
		mSlideMenuTxt = (TextView) findViewById(R.id.slider_menu_new_car);
	}

	private void setSlideMenuListener() {
		
		materialMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mSlideMenu.toggle();
			}
		});
		
		mSlideMenuTxt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(HomeActivity.this, SearchNewCarActivity.class);
				startActivity(mIntent);
			}
		});
	}

	public void toggleSlideMenuWithAnimation(){
		if(mSlideMenu.isMenuShowing()){
			materialMenu.animateState(IconState.BURGER);
		}else{
			materialMenu.animateState(IconState.ARROW);
		}
		mSlideMenu.toggle();
	}
}
