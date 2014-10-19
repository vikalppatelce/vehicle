package com.application.ui;

import android.os.Bundle;
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
import com.balysv.materialmenu.MaterialMenuDrawable.IconState;
import com.balysv.materialmenu.MaterialMenuView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenListener;

public class MotherActivity extends BaseActivity {

	private static String TAG = MotherActivity.class.getSimpleName();

	private TextView mSlideMenuTxt;
	private SlidingMenu mSlideMenu;
	private ActionBar mActionBar;
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
		mSlideMenuTxt = (TextView) findViewById(R.id.slider_menu_txt);
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
				Toast.makeText(MotherActivity.this, "Hello World",
						Toast.LENGTH_SHORT).show();
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
