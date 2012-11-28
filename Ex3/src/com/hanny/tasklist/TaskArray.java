package com.hanny.tasklist;

import java.util.ArrayList;

public class TaskArray {
	
	private ArrayList<TaskItem> tasklist;
	private static TaskArray array;
	
	private TaskArray(){
		tasklist = new ArrayList<TaskItem>();
	}
	
	public static TaskArray getInstance()	{
		
		if(array == null) {
			array = new TaskArray();
		}
		return array;
	}
	 
	public void addTask(TaskItem newTask)
	{
		tasklist.add(getSize(), newTask); 
	}

	public void removeTask(int position)
	{
		tasklist.remove(position);
	}

	public int getSize()
	{
		return tasklist.size();
	}

	public TaskItem getTask(int position)
	{
		return tasklist.get(position);
	}
	

}
