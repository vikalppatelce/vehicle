/* HISTORY
 * CATEGORY			 :- VIEW | HELPER 
 * DEVELOPER		 :- VIKALP PATEL
 * AIM      		 :- PROVIDE FRAGMENT FOR TABS
 * NOTE: HANDLE WITH CARE 
 * 
 * S - START E- END  C- COMMENTED  U -EDITED A -ADDED
 * --------------------------------------------------------------------------------------------------------------------
 * INDEX       DEVELOPER		DATE			FUNCTION		DESCRIPTION
 * --------------------------------------------------------------------------------------------------------------------
 * TU001      VIKALP PATEL     29/07/2014                       CREATED
 * --------------------------------------------------------------------------------------------------------------------
 * 
 * *****************************************METHODS INFORMATION******************************************************** 
 * ********************************************************************************************************************
 * DEVELOPER		  METHOD								DESCRIPTION
 * ********************************************************************************************************************
 * VIKALP PATEL                          			
 * ********************************************************************************************************************
 *
 */

package com.application.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.application.R;
import com.application.ui.FragmentType;
import com.application.ui.FragmentTypeDiesel;
import com.application.ui.FragmentTypePetrol;
import com.application.ui.view.PagerSlidingTabStrip.IconTabProvider;

/**
 * @author Vikalp Patel (vikalppatelce@yahoo.com)
 * @category Ui Helper
 * 
 */
public class ModelBroadPagerAdapter extends FragmentPagerAdapter implements
		IconTabProvider {
	final int PAGE_COUNT = 3;
	private final int[] ICONS = { R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };

	public ModelBroadPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int item) {
		switch (item) {
		case 0:
			FragmentType fragmentFeedAll = new FragmentType();
			return fragmentFeedAll;
		case 1:
			FragmentTypeDiesel fragmentFeedAll1 = new FragmentTypeDiesel();
			return fragmentFeedAll1;
		case 2:
			FragmentTypePetrol fragmentFeedAll3 = new FragmentTypePetrol();
			return fragmentFeedAll3;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

	@Override
	public int getPageIconResId(int position) {
		// TODO Auto-generated method stub
		return ICONS[position];
	}
}
