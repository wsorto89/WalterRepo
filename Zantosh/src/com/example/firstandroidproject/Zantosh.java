package com.example.firstandroidproject;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Zantosh extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1);
		
		ImageButton b = (ImageButton) findViewById(R.id.imageView2);
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Zantosh.class);
				intent.setAction("ACTION_MAIN");
				intent.addCategory("CATEGORY_LAUNCHER");
				
				PackageManager pm = v.getContext().getPackageManager();
				List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
				try {
					ActivityInfo ai = pm.getActivityInfo(new ComponentName(v.getContext(), "com.android.settings"), Intent.FLAG_ACTIVITY_NEW_TASK);
					
					Intent intent2 = new Intent(v.getContext(), Zantosh.class);
					intent2.setAction("ACTION_MAIN");
					intent2.addCategory("CATEGORY_LAUNCHER");
					intent2.setComponent(new ComponentName(ai.packageName, ai.name));
					v.getContext().startActivity(intent2);
					
				} catch (NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void scrollToTop(View v){
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my, menu);
		return true;
	}

}
