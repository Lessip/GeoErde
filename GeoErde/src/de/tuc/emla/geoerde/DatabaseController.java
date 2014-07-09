package de.tuc.emla.geoerde;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// a class which provides a database controller with its objects and methods
public class DatabaseController extends SQLiteOpenHelper 
{
	private static final String LOGCAT = "GE-DatabaseController";
	private static final boolean D = true;
	private SQLiteDatabase database;
	
	private boolean activeTransaction = false;
	
	// the constructor which creates the database
	public DatabaseController(Context applicationcontext)
	{
		super(applicationcontext, "GeoErde.db", null, 1);
		if(D) Log.d(LOGCAT,"Database Created");		
	}
	
	// the constructor which creates the database
	public boolean getActiveTransactionState()
	{
		return database.inTransaction();
	}
	
	// start a new database transaction
	public void startTransaction()
	{
		database = this.getWritableDatabase();
		database.beginTransaction();
		activeTransaction = true;
		if(D) Log.d(LOGCAT,"Database beginTransaction");
	}
	
	// method to end the current transaction
	public void stopTransaction()
	{
		if(activeTransaction)
		{
			activeTransaction = false;
			database.endTransaction();
			database.close();
			if(D) Log.d(LOGCAT,"Database endTransaction");
		}		
	}
	
	// Method to set a transaction successful
	public void successfulTransaction()
	{
		if(activeTransaction)
		{
			database.setTransactionSuccessful();
			if(D) Log.d(LOGCAT,"Database setTransactionSuccessful");
		}
	}
	
	/*
	 * Method to create the table
	 * (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase database)
	{
		createTableStatistics(database);
	}
	
	/* 
	 * Method which is called when the database is upgraded
	 * (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version)
	{
		 String query;
		 // delete the table
		 query = "DROP TABLE IF EXISTS statistics";
		 database.execSQL(query);
		 // and insert it again
		 onCreate(database);
	}
	
	public void createTableStatistics(SQLiteDatabase database)
	{
		String CREATE_TABLE_MEASUREMENTS =
				"CREATE TABLE IF NOT EXISTS statistics ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "lesson TEXT,"
				+ "total INTEGER,"
		        + "correct INTEGER,"
		    	+ "date_time INTEGER);";
		    
		database.execSQL(CREATE_TABLE_MEASUREMENTS);
		if(D) Log.d(LOGCAT,"Table statistics Created");
	}
	
	/* 
	 * Method to store a single measurement-record into the database
	 */
	public void insertDataSet(ContentValues dataset)
	{
		try
		{
			database.insertOrThrow("statistics", null, dataset);            
        }
		catch (Exception e)
        {
			if(D) Log.d(LOGCAT, "Db-insert error: " + e);
        }
	}

	/*
	 * Method to read all stored records from the database
	 */
	public Cursor getGeneralResult()
	{
		Cursor cursor = null;
		
		if(D) Log.d(LOGCAT,"Read all DB entries");
		try
		{
			database = this.getWritableDatabase();
			String selectQuery = "SELECT  * FROM statistics GROUP BY lesson ORDER BY lesson;";
			cursor = database.rawQuery(selectQuery, null);
		    
		}
		catch(Exception e)
		{
			if(D) Log.d(LOGCAT,"(getStoredValues) Db-read error: " + e);
		}
		
		return cursor;
	}
	
	/*
	 * Method to read the stored records for a specific lesson
	 */
	public Cursor getLessonResult(String lesson)
	{
		Cursor cursor = null;
		
		if(D) Log.d(LOGCAT,"Read all DB entries");
		try
		{
			database = this.getWritableDatabase();
			String selectQuery = "SELECT  * FROM statistics WHERE lesson='" + lesson + "';";
			cursor = database.rawQuery(selectQuery, null);
		    
		}
		catch(Exception e)
		{
			if(D) Log.d(LOGCAT,"(getStoredValues) Db-read error: " + e);
		}
		
		return cursor;
	}
	
	/*
	 * Method to delete a single record from the database 
	 */
	public void deleteDataSet(String id)
	{
		if(D) Log.d(LOGCAT,"Delete dataset " + id);
		try
		{
			database = this.getWritableDatabase(); 
			String deleteQuery = "DELETE FROM statistics where id='"+ id +"'";
			if(D) Log.d("delete query",deleteQuery);  
			database.execSQL(deleteQuery);
			database.close();
		}
		catch(Exception e)
		{
			if(D) Log.d(LOGCAT,"(deleteDataSet) Db delete rror: " + e);
		}
	}
	
	/*
	 * Method to delete all data within the database 
	 */
	public void emptyDb()
	{
		if(D) Log.d(LOGCAT,"Empty Db");
		try
		{
			database = this.getWritableDatabase(); 
			//String deleteQuery = "DELETE FROM measurements";
			String deleteQuery = "DROP TABLE IF EXISTS statistics";
			database.execSQL(deleteQuery);
			this.createTableStatistics(database);
			database.close();
		}
		catch(Exception e)
		{
			if(D) Log.d(LOGCAT,"(emptyDb) Db-delete error: " + e);
		}
	}
}
