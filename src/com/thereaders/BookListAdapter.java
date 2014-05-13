package com.thereaders;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class BookListAdapter extends ArrayAdapter<DataCollection> {
	
	public BookListAdapter(Context context, int textViewResourceId,
			DataCollection[] objects) {
		super(context, textViewResourceId, objects);
	}

//		final ImageView bookImageView = (ImageView)view.findViewById(R.id.bookImageView);
//		final TextView bookTitleTexrView = (TextView)view.findViewById(R.id.bookTitleTextView);
//		
//		bookImageView.setImageResource(R.drawable.ic_launcher);
//		bookTitleTexrView.setText(cursor.getString(cursor.getColumnIndex("title")));
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.list_item_note, parent, false);

	    ImageView imageView = (ImageView) rowView.findViewById(R.id.noteImageView);
	    TextView textView = (TextView) rowView.findViewById(R.id.noteTextView);

	    textView.setText(getItem(position).getAuthor().getName());
		imageView.setImageResource(R.drawable.ic_launcher);

	    return rowView;
	  }

		
}
