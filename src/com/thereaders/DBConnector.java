package com.thereaders;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

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
		db.execSQL("create table " + TBL_AUTHOR 
				+ "(idx integer primary key autoincrement,"
				+ "name varchar(30) unique)");

		db.execSQL("create table " + TBL_PUBLISHER 
				+ "(idx integer primary key autoincrement,"
				+ "name varchar(30) unique)");

		db.execSQL("create table " + TBL_BOOK
				+ "(idx integer primary key autoincrement,"
				+ "author_idx integer,"
				+ "publisher_idx integer,"
				+ "name varchar(100) unique,"
				+ "num_page integer)");

		db.execSQL("create table " + TBL_NOTE
				+ "(book_idx integer,"
				+ "txt varchar(400),"
				+ "num_page integer,"
				+ "datetime datetime)");
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

	public DataCollection[] getAllBooks() {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TBL_BOOK,
				new String[] { COL_IDX, COL_AUTHOR_IDX, COL_PUBLISHER_IDX, COL_NAME, COL_NUM_PAGE },
				null, null, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();
		
		DataCollection[] dataCollections = new DataCollection[cursor.getCount()];
		
		for(int i = 0; i < cursor.getCount(); i++) {
			dataCollections[i] = new DataCollection(new Book(cursor.getInt(0), cursor.getInt(1),
					cursor.getInt(2), cursor.getString(3), cursor.getInt(4)));
			cursor.moveToNext();
		}

		return dataCollections;
	}
	
	public DataCollection[] getAllAuthor() {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TBL_AUTHOR,
				new String[] { COL_IDX, COL_NAME },
				null, null, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();
		
		DataCollection[] dataCollections = new DataCollection[cursor.getCount()];
		
		for(int i = 0; i < cursor.getCount(); i++) {
			dataCollections[i] = new DataCollection(new Author(cursor.getInt(0), cursor.getString(1)));
			cursor.moveToNext();
		}

		return dataCollections;
	}

	public void addTestcases() {
		SQLiteDatabase db = this.getWritableDatabase();
		long result;

		try {
			for (int i = 0; i < 10; i++) {
				ContentValues values = new ContentValues();
				values.put("name", "author" + i);

				result = db.insert(TBL_AUTHOR, null, values);
			}

			for (int i = 0; i < 10; i++) {
				ContentValues values = new ContentValues();
				values.put("name", "publisher" + i);

				result = db.insert(TBL_PUBLISHER, null, values);
			}

			for (int i = 0; i < 10; i++) {
				ContentValues values = new ContentValues();
				values.put("author_idx", i);
				values.put("publisher_idx", i);
				values.put("name", "book" + i);
				values.put("num_page", i * 100);

				result = db.insert(TBL_BOOK, null, values);
			}

			for (int i = 0; i < 10; i++) {
				ContentValues values = new ContentValues();
				values.put("book_idx", i);
				values.put("txt", "txt" + i);
				values.put("num_page", i * 100);
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				values.put("datetime", dateFormat.format(date));

				result = db.insert(TBL_NOTE, null, values);
			}
		} catch (Exception e) {
		}
	}
	
//	public DataCollection[] getNotes(int idx) {
//		SQLiteDatabase db = this.getReadableDatabase();
//		
//		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
//		qb.setTables(TBL_NOTE );
//
//		Cursor cursor = db.query(TBL_NOTE,
//				new String[] { COL_IDX, COL_NAME },
//				COL_IDX + "=?",
//				new String[] { String.valueOf(idx) },
//				null, null, null, null);
//
//		if (cursor != null)
//			cursor.moveToFirst();
//
//		Author author = new Author(cursor.getInt(0), cursor.getString(1));
//
//		return author;
//	}

}
