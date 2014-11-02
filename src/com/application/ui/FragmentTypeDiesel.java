package com.application.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.R;

public class FragmentTypeDiesel extends Fragment{

	private TextView mTextView;
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_type, container, false);
		mTextView = (TextView)view.findViewById(R.id.textview);
		mTextView.setText("Diesel");
		return view;
	}

}
