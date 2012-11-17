package com.hanny.tasklist;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListBaseAdapter extends BaseAdapter {

		private static ArrayList<TaskItem> itemDetailsrrayList;
		private LayoutInflater l_Inflater;

		public TaskListBaseAdapter(Context context) {
			l_Inflater = LayoutInflater.from(context);
			itemDetailsrrayList = TaskArray.getInstance();
		}

		public int getCount() {
			return itemDetailsrrayList.size();
		}

		public Object getItem(int position) {
			return itemDetailsrrayList.get(position);
		}

		
		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = l_Inflater.inflate(R.layout.item_task, null);
				holder = new ViewHolder();
				holder.txt_itemTitle = (TextView) convertView.findViewById(R.id.task_title);
				holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.task_description);;
			

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.txt_itemTitle.setText(itemDetailsrrayList.get(position).getTitle());
			holder.txt_itemDescription.setText(itemDetailsrrayList.get(position).getDescription());
			//holder.itemImage.setImageDrawable(R.drawable.todo);

			return convertView;
		}

		static class ViewHolder {
			TextView txt_itemTitle;
			TextView txt_itemDescription;
			//ImageView itemImage;
		}
	}