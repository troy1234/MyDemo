package com.example.fragments;

import com.example.demo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LeftMenuFragment extends Fragment {

//	@ViewInject(R.id.left_menu_list)
	private ListView mlistView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.list, null);
	}
	
	//当activity Oncreat执行完成后，会执行onActivityCreated
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		String[] colors = getResources().getStringArray(R.array.color_names);
//		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
//				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
//		mlistView.setAdapter(colorAdapter);
//		mlistView.setOnItemClickListener(new myOnItemClickListener());
	}
	
	
	class myOnItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
		}
		
	}
//	@Override
//	public void onListItemClick(ListView lv, View v, int position, long id) {
//		Fragment newContent = null;
//		switch (position) {
//		case 0:
//			newContent = new ColorFragment(R.color.red);
//			break;
//		case 1:
//			newContent = new ColorFragment(R.color.green);
//			break;
//		case 2:
//			newContent = new ColorFragment(R.color.blue);
//			break;
//		case 3:
//			newContent = new ColorFragment(android.R.color.white);
//			break;
//		case 4:
//			newContent = new ColorFragment(android.R.color.black);
//			break;
//		}
//		if (newContent != null)
//			switchFragment(newContent);
//	}
//	
}
