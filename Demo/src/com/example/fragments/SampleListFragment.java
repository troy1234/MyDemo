package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demo.MainActivity;
import com.example.demo.R;

public class SampleListFragment extends ListFragment {
	
	String name[]={"新闻","订阅","图片","视频","跟帖","投票"};
	
	Fragment MainFragment;
	Fragment SecondFragment;
	Fragment ThreeFragment;
	
	
	public Fragment getMainFragment(){
		if(MainFragment==null){
			Log.d("SampleListFragment","创建首页");
			MainFragment=new MainFragment();
		}
		return MainFragment;
	}
	
	
	public Fragment getSecondFragment(){
		if(SecondFragment==null){
			SecondFragment=new SecondPartFragment();
		}
		return SecondFragment;
	}
	
	public Fragment getThreeFragment(){
		if(ThreeFragment==null){
			ThreeFragment=new ThreePartFragment();
		}
		return ThreeFragment;
	}
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for(int i=0;i<name.length;i++){
			adapter.add(new SampleItem(name[i], android.R.drawable.ic_menu_search));
		}
		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			switchFragment(getMainFragment());
			break;
		case 1:
			switchFragment(getSecondFragment());
			break;
		case 2:
			
			switchFragment(getThreeFragment());
			break;
		case 3:
			switchFragment(getThreeFragment());
			break;
		case 4:
			switchFragment(getThreeFragment());
			break;
		}
		
	}
	
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		}
	}
}
