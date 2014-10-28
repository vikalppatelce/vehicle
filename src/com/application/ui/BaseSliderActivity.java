package com.application.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.application.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseSliderActivity extends SlidingFragmentActivity {

	protected ListFragment mFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_slide);
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		setSlidingActionBarEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}
