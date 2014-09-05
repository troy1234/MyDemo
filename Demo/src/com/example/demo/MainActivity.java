package com.example.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.viewpagerindicator.TitlePageIndicator.OnCenterItemClickListener;

//@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements
		OnCenterItemClickListener {

	// @ViewInject(R.id.indicator)
	// private TitlePageIndicator mHttpBtn;
	// @ViewInject(R.id.pager)
	// private ViewPager mViewPager;
	// @ViewInject(R.id.indicator)
	// TabPageIndicator indicator;
	//
	// private List<Fragment> mFragments;
	//
	// private ViewPagerAdapter mViewPagerAdapter;

	private Fragment mContent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ViewUtils.inject(this);
		Log.d("xxx","MainActivity-OnCreat");
		setContentView(R.layout.content_frame);

		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
			
		if (mContent == null) {
			mContent = mMainFragment;
		}

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mContent).commit();

	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}

	@Override
	public void onCenterItemClick(int position) {
		// TODO Auto-generated method stub

	}

	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mContent).commit();
		
		getSlidingMenu().showContent();
	}

}
