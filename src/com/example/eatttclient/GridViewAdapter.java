package com.example.eatttclient;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	ArrayList<HashMap<String, String>> data;
	LayoutInflater inflater;
	Context c;
	HashMap<String, String> resultp = new HashMap<String, String>();
	View itemview;
	public GridViewAdapter(Context context,
			ArrayList<HashMap<String, String>> arrayList) {
		data = arrayList;
		this.c=context;
		inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		System.out.println("getcount function"+data.size());
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		if(convertView==null){
		itemview=inflater.inflate(R.layout.grid_items, parent, false);
		//convertView.setTag(R.id.text_view, convertView.findViewById(R.id.text_view)); 
		}
		resultp=data.get(position);
		System.out.println(resultp);
		TextView textView=(TextView) itemview.findViewById(R.id.text_view);
		textView.setText(resultp.toString());
		itemview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resultp=data.get(position);
				String string=resultp.get("status").toString();
				System.out.println("click view function"+string);
				if(string.contains("0")){
					System.out.println(string);
					Intent intent=new Intent(c,TableAssignActivity.class);
					intent.putExtra("table_no", resultp.get("table_no"));
					intent.putExtra("status", resultp.get("status"));
					intent.putExtra("id", resultp.get("id"));
					c.startActivity(intent);
					
				}else if (string.contains("4")) {
					Intent intent=new Intent(c,OrderItemsActivity.class);
					c.startActivity(intent);
					
				}

				
			}
		});
		return itemview;
	}

}
