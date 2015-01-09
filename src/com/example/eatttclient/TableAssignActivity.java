package com.example.eatttclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TableAssignActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_assign);
		Intent intent=getIntent();
		String string=intent.getStringExtra("table_no");
		TextView textView=(TextView) findViewById(R.id.table_textview);
		textView.setText("Table NO. " +string);
	}
}
