package com.application.ui.view;

import com.application.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VahanIndiaProgressDialog extends Dialog {
	private ImageView mImageView;
	private AnimationDrawable mProgressAnimation;

	public VahanIndiaProgressDialog(Context mContext) {
		super(mContext, R.style.transparentProgressDialog);
		WindowManager.LayoutParams mLayoutParams = getWindow()
				.getAttributes();
		mLayoutParams.gravity = 1;
		getWindow().setAttributes(mLayoutParams);
		setTitle(null);
		setCancelable(false);
		setOnCancelListener(null);
		LinearLayout mLinearLayout = new LinearLayout(mContext);
		mLinearLayout.setOrientation(1);
		LinearLayout.LayoutParams mLayoutParams1 = new LinearLayout.LayoutParams(
				-1, -2);
		mImageView = new ImageView(mContext);
		mLinearLayout.addView(mImageView, mLayoutParams1);
		TextView mTextView = new TextView(mContext);
		mTextView.setText("Loading...");
		mTextView.setGravity(17);
		mTextView.setTextSize(2, 20.0F);
		mTextView.setTextColor(Color.WHITE);
		mLinearLayout.addView(mTextView, mLayoutParams1);
		addContentView(mLinearLayout, mLayoutParams1);
		WindowManager.LayoutParams mLayoutParams2 = getWindow()
				.getAttributes();
		mLayoutParams2.dimAmount = 0.8F;
		getWindow().setAttributes(mLayoutParams2);
		getWindow().addFlags(2);
	}

	public void show() {
		mImageView.setBackgroundResource(R.anim.loading_anim);
		mProgressAnimation = ((AnimationDrawable) mImageView.getBackground());
		setOnShowListener(new DialogInterface.OnShowListener() {
			public void onShow(DialogInterface paramAnonymousDialogInterface) {
				VahanIndiaProgressDialog.this.mProgressAnimation.start();
			}
		});
		super.show();
	}
}