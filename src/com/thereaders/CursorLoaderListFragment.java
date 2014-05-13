package com.thereaders;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;


public class CursorLoaderListFragment extends ListFragment {

	// This is the Adapter being used to display the list's data.
	BookListAdapter bookListAdapter;

	// The SearchView for doing filtering.
	SearchView mSearchView;

	// If non-null, this is the current filter the user has provided.
	String mCurFilter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		DBConnector dbConnector = new DBConnector(getActivity(), Constants.DB_NAME, null, Constants.DB_VERSION);
		dbConnector.addTestcases();
		bookListAdapter = new BookListAdapter(getActivity(),
				R.layout.list_item_book, dbConnector.getAllAuthor());

		setListAdapter(bookListAdapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Insert desired behavior here.
		Log.i("FragmentComplexList", "Item clicked: " + 
				 bookListAdapter.getItem(position).getAuthor().getIdx() + 
				 bookListAdapter.getItem(position).getAuthor().getName());
	}
}