package com.hanny.tasklist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateTaskActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
		
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        
        final TaskArray taskList = TaskArray.getInstance();
		Button createActivityButton = (Button) findViewById(R.id.create);
		createActivityButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				TaskItem task = new TaskItem();
		        EditText titleFiled = (EditText)findViewById(R.id.title);
		        EditText descriptionFiled = (EditText)findViewById(R.id.description);
		        
		        task.setTitle(titleFiled.getText().toString());
				task.setDescription(descriptionFiled.getText().toString());
				
				taskList.addTask(task);

				finish();
				
			}
		});
        
        
    }

}
