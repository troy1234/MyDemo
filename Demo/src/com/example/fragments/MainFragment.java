package com.example.fragments;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.ViewPagerAdapter;
import com.example.demo.R;
import com.example.view.MainFragment1;
import com.example.view.MainFragment2;
import com.example.view.MainFragment3;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.viewpagerindicator.TabPageIndicator;

/**
 * 
 * 主页面配合ViewPager使用
 * @author aa
 *
 */
public class MainFragment extends Fragment {

	private ViewPager mViewPager;
	private TabPageIndicator indicator;

	private List<Fragment> mFragments;

	private ViewPagerAdapter mViewPagerAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_main, null);
	}
	
	public MainFragment() {
		// TODO Auto-generated constructor stub
		setRetainInstance(true);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mViewPager = (ViewPager) getActivity().findViewById(R.id.pager);
		indicator = (TabPageIndicator) getActivity().findViewById(
				R.id.indicator);
		initMainView();
		mViewPager.setAdapter(mViewPagerAdapter);
		indicator.setViewPager(mViewPager);
		indicator.setOnPageChangeListener(new myPageChangeListener());
	}
	

	@SuppressLint("NewApi")
	private void initMainView() {
		if (mFragments == null) {
			Log.d("xxx","111");
			mFragments = new ArrayList<Fragment>();
			mFragments.add(new MainFragment1());
			mFragments.add(new MainFragment2());
			mFragments.add(new MainFragment3());
		}
		
		if (mViewPagerAdapter == null) {
			FragmentManager fm = getActivity().getSupportFragmentManager();
//			FragmentManager fm = this.getChildFragmentManager();
			mViewPagerAdapter = new ViewPagerAdapter(fm, mFragments);
			
		}
		mViewPagerAdapter.notifyDataSetChanged();
	}
	

	/**
	 * 
	 * @author Troy
	 * 
	 *         viewpager监听
	 * 
	 */
	public class myPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				((SlidingFragmentActivity) getActivity()).getSlidingMenu()
						.setMode(SlidingMenu.LEFT);
				Log.d("xxx", "ViewPagerActivity:position:0");
				((SlidingFragmentActivity) getActivity()).getSlidingMenu()
						.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				break;
			case 2:
				((SlidingFragmentActivity) getActivity()).getSlidingMenu()
						.setMode(SlidingMenu.RIGHT);
				Log.d("xxx", "ViewPagerActivity:position:2");
				((SlidingFragmentActivity) getActivity()).getSlidingMenu()
						.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				break;
			default:
				Log.d("xxx", "ViewPagerActivity:position:1");
				((SlidingFragmentActivity) getActivity()).getSlidingMenu()
						.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				break;
			}
		}

	}

}
