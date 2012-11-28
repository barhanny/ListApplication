package com.hanny.tasklist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaskListActivity extends Activity {

	private TaskListBaseAdapter adapter;
	//private Context context;
    
    public void onCreate(Bundle savedInstanceState) {
    	
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        
        //context = this;
        Button addTask = (Button)findViewById(R.id.add_task);
        TextView deleteMsg = (TextView)findViewById(R.id.delete_msg);
        

        
		//ArrayList<TaskItem> taskArray = TaskArray.getInstance();
		
		ListView taskList = (ListView) findViewById(R.id.task_list);
		adapter = new TaskListBaseAdapter(this);
		taskList.setAdapter(adapter);
		
        addTask.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent taskActivity = new Intent(v.getContext(),CreateTaskActivity.class);
				startActivity(taskActivity);
			}
		});
    }
    
    @Override	
	public void onResume()
	{
		super.onResume();
		adapter.notifyDataSetChanged();
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
