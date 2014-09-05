package com.example.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.example.demo.R;
import com.viewpagerindicator.IconPagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter implements
		IconPagerAdapter {

	private List<Fragment> contents;
	protected static final String[] CONTENT = new String[] { "A", "B", "C" };
	private static final int[] ICONS = new int[] {
			R.drawable.perm_group_calendar, R.drawable.perm_group_camera,
			R.drawable.perm_group_device_alarms,
			R.drawable.perm_group_location, };

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	public ViewPagerAdapter(FragmentManager fm, List<Fragment> lcontents) {
		super(fm);
		// TODO Auto-generated constructor stub
		contents = lcontents;
	}

	


	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Log.d("xxx", "getItem:" + arg0);
		return contents.get(arg0);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contents.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {

		return ViewPagerAdapter.CONTENT[position];
	}

	@Override
	public int getIconResId(int index) {
		return ICONS[index];
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		Log.d("xxx", "instantiateItem");
		container.invalidate();
		return super.instantiateItem(container, position);
	}
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		Log.d("xxx", "destroyItem");
		super.destroyItem(container, position, object);
	}

}
