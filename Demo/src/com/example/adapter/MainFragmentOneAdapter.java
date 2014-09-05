package com.example.adapter;

import java.util.List;

import com.example.demo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MainFragmentOneAdapter extends BaseAdapter {

	private List<String> mList;
	private LayoutInflater mInflater;
	public MainFragmentOneAdapter(List<String> lList,Context lContext){
		mInflater=LayoutInflater.from(lContext);
		mList=lList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(arg1==null){
			arg1=mInflater.inflate(R.layout.main_listview_item, null);  
		}
		
		return arg1;
	}

}
