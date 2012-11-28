package com.hanny.tasklist;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListBaseAdapter extends BaseAdapter {

		private static TaskArray itemDetailsrrayList;
		private LayoutInflater l_Inflater;
		private boolean state = false;

		public TaskListBaseAdapter(Context context) {
			l_Inflater = LayoutInflater.from(context);
			itemDetailsrrayList = TaskArray.getInstance();
		}

		public int getCount() {
			return itemDetailsrrayList.getSize();
		}

		public Object getItem(int position) {
			return itemDetailsrrayList.getTask(position);
		}

		
		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			final ViewHolder holder;
			
			
			if (convertView == null) {
				convertView = l_Inflater.inflate(R.layout.item_task, null);
				holder = new ViewHolder();
				holder.txt_itemTitle = (TextView) convertView.findViewById(R.id.task_title);
				holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.task_description);
				//holder.txt_clearTask = (TextView) convertView.findViewById(R.id.clear_task);
				holder.doneButton = (Button)convertView.findViewById(R.id.task_button);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.txt_itemTitle.setText(itemDetailsrrayList.getTask(position).getTitle());
			holder.txt_itemTitle.setOnTouchListener(new OnTouchListener() {
				
				public boolean onTouch(View v, MotionEvent event) {
			        if(event.getAction() == MotionEvent.ACTION_DOWN) {
						itemDetailsrrayList.removeTask(position);
						notifyDataSetChanged();
						return true;
			        }		
					return false;
				}
			});
			holder.txt_itemDescription.setText(itemDetailsrrayList.getTask(position).getDescription());
			//holder.txt_clearTask.setOnClickListener(new OnClickListener() {
				
				//public void onClick(View v) {
					//itemDetailsrrayList.removeTask(position);
					//notifyDataSetChanged();
					
				//}
			//});
			holder.doneButton.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v){
					if(state) {
						v.setBackgroundResource(R.drawable.taskicon_default);
						//ViewHoldestate = 0;
						} else {
						v.setBackgroundResource(R.drawable.taskicon_push);
						//ViewHolder.state = 1;
					}
					state = !state;
				}
			});

			return convertView;
		}

		static class ViewHolder {
			TextView txt_itemTitle;
			TextView txt_itemDescription;
			TextView txt_clearTask;
			Button doneButton;
		}
	}