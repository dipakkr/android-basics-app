package com.dipakkr.github.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dipakkr.github.sqliteexample.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak on 6/7/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private final static String TAG = MainActivity.class.getSimpleName();

    private static final int  DATABASE_VERSION = 1;
    //DB name
    private static final String DATABASE_NAME = "studentdb";
    //Table name
    private static final String TABLE_NAME = "student";

    //columns name
    private static String KEY_ID = "id";
    private static String KEY_NAME = "name";
    private static String KEY_SUB = "subject";

    private static final String CREATE_TABLE = "CREATE TABLE "  + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_NAME + "TEXT ," + KEY_SUB + " TEXT" + ")";


    public DatabaseHandler(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Upgrade table, remove old
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //create again
        onCreate(db);
    }

    //Adding new Students
    void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID,student.getId());
        contentValues.put(KEY_NAME,student.getName());
        contentValues.put(KEY_SUB,student.getSubject());
        Log.d(TAG,"ID : " + student.getId());
        Log.d(TAG,"name : " + student.getName());
        Log.d(TAG,"Sub : " + student.getSubject());

        //insert the table
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public List<Student> getAllStudents(){
        List<Student> list_student = new ArrayList<Student>();

        //apply select all query
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query,null);

        if(cursor.moveToFirst()){
          do{
              Student student = new Student();
              student.setId(Integer.parseInt(cursor.getString(0)));
              student.setName(cursor.getString(1));
              student.setSubject(cursor.getString(2));

              //add students to list
              list_student.add(student);
          }while (cursor.moveToNext());
        }
        return list_student;
    }

}
