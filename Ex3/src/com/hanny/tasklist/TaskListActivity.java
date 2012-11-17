package com.hanny.tasklist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends Activity {

	private TaskListBaseAdapter adapter;
	private Context context;
    
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        
        context = this;
        Button addTask = (Button)findViewById(R.id.add_task);
        

        
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
    
    public void DoneButton(View v) {
    	Button taskButton = (Button)findViewById(R.id.task_image);
    	Toast.makeText(context, "going to  done ",2000).show();
    	if(v == taskButton) {
    		taskButton.setBackgroundResource(R.drawable.taskicon);
    		Toast.makeText(context, "done done ",3000).show();
    	} //else{
    		//taskButton.setBackgroundResource(R.drawable.taskicon);
    		//Toast.makeText(context, "done ",2000).show();
    	//}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
