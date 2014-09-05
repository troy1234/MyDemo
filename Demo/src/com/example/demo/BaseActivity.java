package com.example.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.fragments.SampleListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.viewpagerindicator.PageIndicator;

public class BaseActivity extends SlidingFragmentActivity {
	
	
	PageIndicator mIndicator;
	protected SampleListFragment mFrag;
	protected Fragment mMainFragment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//设置左侧菜单
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			
			mFrag = new SampleListFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (SampleListFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}
		
		mMainFragment=mFrag.getMainFragment();
		
		//设置右侧菜单
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
//		getSupportFragmentManager().beginTransaction()
//				.replace(R.id.menu_frame_two, mFrag)
//				.commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);//设置阴影宽度
		sm.setShadowDrawable(R.drawable.shadow);//设置阴影背景
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);//设置菜单宽度
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
}
