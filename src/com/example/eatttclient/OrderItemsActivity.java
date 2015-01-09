package com.example.eatttclient;

import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class OrderItemsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_items);
		Button button=(Button) findViewById(R.id.textview_orderitems);
		button.setText("Add order items");
	}
}
