package com.example.jia1;

import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	ImageView show;
	int[] imageids=new int[]{
			R.drawable.schedule_bk,
			R.drawable.schedule_type,
			R.drawable.top_day,
			R.drawable.top,
			R.drawable.week_top
	};
	int currentimage=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main );
        show=(ImageView) findViewById(R.id.show);
        final Handler myhanHandler=new Handler(){
        	public void handleMessage(android.os.Message msg) {
        		if(msg.what==0x1233){
        			show.setImageResource(imageids[currentimage++]);
        			if(currentimage>=4){
        				currentimage=0;
        			}
        		}
        	};
        };
    new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message msg=new Message();
				msg.what=0x1233;
				myhanHandler.sendMessage(msg);
			}
        	
        }, 0,800);
   
 }}


