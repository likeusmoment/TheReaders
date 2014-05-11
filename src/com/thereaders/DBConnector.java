package com.thereaders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {

	public DBConnector(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	// for tables
	static final String TBL_AUTHOR = "author";
	static final String TBL_PUBLISHER = "publisher";
	static final String TBL_BOOK = "book";
	static final String TBL_NOTE = "note";

	// for columns
	static final String COL_IDX = "idx";
	static final String COL_NAME = "name";
	static final String COL_AUTHOR_IDX = "author_idx";
	static final String COL_PUBLISHER_IDX = "publisher_idx";
	static final String COL_NUM_PAGE = "num_page";
	static final String COL_TXT = "txt";
	static final String COL_DATETIME = "datetime";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table ? "
				+ "(idx int unsigned primary key auto_increment,"
				+ "name varchar(30) unique)",
				new String[] { TBL_AUTHOR });

		db.execSQL("create table ? "
				+ "(idx int unsigned primary key auto_increment,"
				+ "name varchar(30) unique)",
				new String[] { TBL_PUBLISHER });

		db.execSQL("create table ? "
				+ "(idx int unsigned primary key auto_increment,"
				+ "author_idx int unsigned,"
				+ "publisher_idx int unsigned,"
				+ "name varchar(100) unique,"
				+ "num_page int unsigned)",
				new String[] { TBL_BOOK });

		db.execSQL("create table ? "
				+ "(book_idx int unsigned,"
				+ "txt varchar(400),"
				+ "num_page int unsigned,"
				+ "datetime datetime)",
				new String[] { TBL_NOTE });
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void addAuthor(Author author) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COL_NAME, author.getName());

		db.insert(TBL_AUTHOR, null, values);
		db.close();
	}
	
	public Author getAuthor(int idx) {
		// TODO: to be implemented
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TBL_AUTHOR,
				new String[] { COL_IDX, COL_NAME },
				COL_IDX + "=?",
				new String[] { String.valueOf(idx) },
				null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();

		Author author = new Author(cursor.getInt(0), cursor.getString(1));

		return author;
	}

}
