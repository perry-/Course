package com.perry.ntnu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<Course> {

	private ArrayList<Course> items;
	Context mContext;

	public CustomAdapter(Context context, int textViewResourceId, ArrayList<Course> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.mContext = context;
	}

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		if(row == null){
			LayoutInflater inflater = ((MyActivity)mContext).getLayoutInflater();
			row = inflater.inflate(R.layout.list_item, parent, false);
		}
		TextView idlabel = (TextView) row.findViewById(R.id.coursecode);
		TextView namelabel = (TextView) row.findViewById(R.id.coursename);
        Course course = items.get(position);
        namelabel.setText(course.getName());
        idlabel.setText(course.getCode());


		return row;

	}
}