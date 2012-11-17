package com.hanny.tasklist;

import java.util.ArrayList;

public class TaskArray {
	
	static private ArrayList<TaskItem> tasklist = null;
	private TaskArray(){
		tasklist = new ArrayList<TaskItem>();
	}
	
	public static ArrayList<TaskItem> getInstance()	{
		if(tasklist == null) {
			tasklist = new ArrayList<TaskItem>();
		}
		return tasklist;
	}
	 

	

}
