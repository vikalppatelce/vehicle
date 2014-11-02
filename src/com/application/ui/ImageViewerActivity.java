package com.application.ui;

import it.sephiroth.horizontallistview.HListView;

import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.application.R;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

public class ImageViewerActivity extends SherlockFragmentActivity implements
		BaseSliderView.OnSliderClickListener {

	private SliderLayout mDemoSlider;
	private HListView mHListView;

	private ImageCategoryAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_viewer);
		initUi();

		setSliderAdapter();
		mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
		mDemoSlider
				.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
		mDemoSlider.setCustomAnimation(new DescriptionAnimation());
		mDemoSlider.setDuration(400);

		setAdapter();
	}

	private void initUi() {
		mDemoSlider = (SliderLayout) findViewById(R.id.slider);
		mHListView = (HListView) findViewById(R.id.activity_image_viewer_hlistview);
	}

	public void setSliderAdapter() {

		HashMap<String, String> url_maps = new HashMap<String, String>();
		url_maps.put(
				"Hannibal Hannibal Hannibal Hannibal",
				"http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
		url_maps.put("Big Bang Theory",
				"http://tvfiles.alphacoders.com/100/hdclearart-10.png");
		url_maps.put("House of Cards",
				"http://cdn3.nflximg.net/images/3093/2043093.jpg");
		url_maps.put(
				"Game of Thrones",
				"http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
		url_maps.put(
				"H",
				"http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
		url_maps.put("B",
				"http://tvfiles.alphacoders.com/100/hdclearart-10.png");
		url_maps.put("H", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
		url_maps.put(
				"G",
				"http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

		for (String name : url_maps.keySet()) {
			TextSliderView textSliderView = new TextSliderView(this);
			// initialize a SliderLayout
			textSliderView.description(name).image(url_maps.get(name))
					.setScaleType(BaseSliderView.ScaleType.Fit)
					.setOnSliderClickListener(this);

			// add your extra information
			textSliderView.getBundle().putString("extra", name);

			mDemoSlider.addSlider(textSliderView);
		}
	}

	public void changeSliderAdapter() {
		HashMap<String, String> url_maps = new HashMap<String, String>();
		url_maps.put(
				"Hannibal Hannibal Hannibal Hannibal",
				"http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
		url_maps.put("Big Bang Theory",
				"http://tvfiles.alphacoders.com/100/hdclearart-10.png");
		url_maps.put("House of Cards",
				"http://cdn3.nflximg.net/images/3093/2043093.jpg");
		url_maps.put(
				"Game of Thrones",
				"http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

		mDemoSlider.removeAllSliders();
		for (String name : url_maps.keySet()) {
			TextSliderView textSliderView = new TextSliderView(this);
			// initialize a SliderLayout
			textSliderView.description(name).image(url_maps.get(name))
					.setScaleType(BaseSliderView.ScaleType.Fit)
					.setOnSliderClickListener(this);

			// add your extra information
			textSliderView.getBundle().putString("extra", name);

			mDemoSlider.addSlider(textSliderView);
		}
	}

	private void setAdapter() {
		mAdapter = new ImageCategoryAdapter(ImageViewerActivity.this);
		mHListView.setAdapter(mAdapter);
	}

	public class ImageCategoryAdapter extends BaseAdapter {
		Context mContext;
		LayoutInflater mInflater;
		private boolean[] mIsSelected = { false, false, false, false };
		private String TAG = ImageCategoryAdapter.class.getSimpleName();
		private int[] defaultIcon = { R.drawable.petrol, R.drawable.diesel,
				R.drawable.cng, R.drawable.electric };
		private int[] selectIcon = { R.drawable.petrol_tick,
				R.drawable.diesel_tick, R.drawable.cng_tick,
				R.drawable.electric_tick };

		public ImageCategoryAdapter(Context mContext) {
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
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			View v;
			ViewHolder holder = null;

			if (convertView == null) {
				LayoutInflater li = (LayoutInflater) mContext
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = li.inflate(R.layout.item_hlistview_new_car_search, null);
				holder = new ViewHolder();
				holder.mHolderImageView = (ImageView) v
						.findViewById(R.id.item_hlistview_new_car_search_image);
				holder.mHolderLinearLayout = (LinearLayout) v
						.findViewById(R.id.item_hlistview_new_car_search_layout);
				v.setTag(holder);
			} else {
				v = convertView;
				holder = (ViewHolder) v.getTag();
			}

			holder.mHolderImageView.setImageResource(defaultIcon[position]);

			setListener(holder.mHolderLinearLayout, holder.mHolderImageView,
					position);

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

		public void setListener(LinearLayout mHolderLinearLayout,
				final ImageView mHolderImageView, final int position) {
			mHolderLinearLayout.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (mIsSelected[position]) {
						mHolderImageView
								.setImageResource(defaultIcon[position]);
						mIsSelected[position] = false;
					} else {
						mHolderImageView.setImageResource(selectIcon[position]);
						changeSliderAdapter();
						mIsSelected[position] = true;
					}
				}
			});
		}

		public boolean[] getSelectedFuelType() {
			return mIsSelected;
		}

	}

	static class ViewHolder {
		ImageView mHolderImageView;
		LinearLayout mHolderLinearLayout;
	}

	@Override
	public void onSliderClick(BaseSliderView slider) {
		// Toast.makeText(this,slider.getBundle().get("extra") +
		// "",Toast.LENGTH_SHORT).show();
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { MenuInflater
	 * menuInflater = getMenuInflater(); menuInflater.inflate(R.menu.main,menu);
	 * return super.onCreateOptionsMenu(menu); }
	 * 
	 * @Override public boolean onOptionsItemSelected(MenuItem item) { switch
	 * (item.getItemId()){ case R.id.action_custom_indicator:
	 * mDemoSlider.setCustomIndicator((PagerIndicator)
	 * findViewById(R.id.custom_indicator)); break; case
	 * R.id.action_custom_child_animation: mDemoSlider.setCustomAnimation(new
	 * ChildAnimationExample()); break; case R.id.action_restore_default:
	 * mDemoSlider
	 * .setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
	 * mDemoSlider.setCustomAnimation(new DescriptionAnimation()); break; case
	 * R.id.action_github: Intent browserIntent = new Intent(Intent.ACTION_VIEW,
	 * Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
	 * startActivity(browserIntent); break; } return
	 * super.onOptionsItemSelected(item); }
	 */
}
