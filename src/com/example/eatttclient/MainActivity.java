package com.example.eatttclient;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {
	public static String url ="http://demo.eattt.com/api/v1/rest/get_tables/";
	JSONObject jsonObject;
	GridViewAdapter adapter;
	static String id ="id";
	static String table_no="tabble_no";
	static String status="status";
	ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadJson().execute();
    }
    
    class DownloadJson extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			
			jsonObject=JsonGetbid.getJSONfromURL(url, "7");
			try {
				JSONArray jsonarray= jsonObject.getJSONArray("table_details");
				for(int i=0;i<jsonarray.length();i++){
					HashMap<String, String> map = new HashMap<String, String>();
					JSONObject object = jsonarray.getJSONObject(i);
					map.put("id", object.getString("id"));
					map.put("status", object.getString("status"));
					map.put("table_no", object.getString("table_no"));
					arrayList.add(map);
					
				}
				System.out.println(arrayList);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			GridView gridView =(GridView) findViewById(R.id.grid_view);
			//ArrayAdapter<HashMap<String, String>> adapter = new ArrayAdapter<HashMap<String,String>>(MainActivity.this, R.layout.grid_items, arrayList);
			adapter = new GridViewAdapter(MainActivity.this,arrayList);
			gridView.setAdapter(adapter);
			super.onPostExecute(result);
		}
		

    	
    }
}
