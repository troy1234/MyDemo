package com.example.view;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adapter.MainFragmentOneAdapter;
import com.example.demo.R;

public class MainFragment1 extends Fragment {

	private ListView mListView;
	private List<String> mUIDataList;

	private MainFragmentOneAdapter mfoa;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d("xxx","onCreateView");
		return inflater.inflate(R.layout.mainfragment1, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("xxx","onActivityCreated");
		mListView = (ListView) getView().findViewById(R.id.main_fragment_list);
		if (mUIDataList == null) {
			mUIDataList = new ArrayList<String>();
			for (int i = 0; i < 20; i++) {
				mUIDataList.add("列表" + i);
			}
		}

		if(mfoa==null){
			mfoa = new MainFragmentOneAdapter(mUIDataList,
					getActivity());
			mListView.setAdapter(mfoa);
		}else{
			mfoa.notifyDataSetInvalidated();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("xxx","MainFragment1-onDestroy");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("xxx","MainFragment1-onStop");
	}
	
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d("xxx","MainFragment1-onDestroyView");
	}
}
