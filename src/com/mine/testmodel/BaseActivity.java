package com.mine.testmodel;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class BaseActivity extends AppCompatActivity {

	private List<ImageView> imaList = new ArrayList<ImageView>();
	private int[] guidResID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.newbiguid);
	}

	public int[] getGuidResID() {
		return guidResID;
	}

	public void setGuidResID(int[] guidResID) {
		this.guidResID = guidResID;
	}

	protected void onStart() {
		super.onStart();
		if (!(GuidPageMark.activityIsGuided(getApplicationContext(), this
				.getClass().getName()))) {
			addGuidView();
		}
	};

	protected void addGuidView() {
		// 获取根布局
		View guidLayout = getWindow().getDecorView().findViewById(R.id.guidgen);
		// 获取父控件，是framelayout
		ViewParent parent = guidLayout.getParent();
		if (parent instanceof FrameLayout) {
			// 添加引导图片
			final FrameLayout frameLayoutGuid = (FrameLayout) parent;
			if (guidResID == null || guidResID.length == 0)
				return;
			for (int i = 0; i < guidResID.length; i++) {
				final ImageView imageView = new ImageView(this);
				LayoutParams params = new FrameLayout.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT);
				imageView.setLayoutParams(params);
				imageView.setScaleType(ScaleType.FIT_XY);
				imageView.setImageResource(guidResID[i]);
				imaList.add(imageView);
				imageView.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						frameLayoutGuid.removeView(imaList.get(imaList.size() - 1));
						imaList.remove(imaList.size() - 1);
						GuidPageMark.setIsGuided(getApplicationContext(),
								BaseActivity.this.getClass().getName());
						if (imaList.size() > 0) {
							frameLayoutGuid.addView(imaList.get(imaList.size() - 1));
						} else {
							postClick();
						}
					}
				});
			}
			frameLayoutGuid.addView(imaList.get(imaList.size() - 1));
		}
	}

	protected void postClick() {
	}
}
