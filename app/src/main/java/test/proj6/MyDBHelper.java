package test.proj6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDBHelper {
    private static SQLiteDatabase mSqLiteDatabase;
    private static DataBaseHelper  mDatabaseHelper;

    public static void onObjAdd(Context context, String objId, String objName){
        //if(mDatabaseHelper == (null))
        mDatabaseHelper = new DataBaseHelper(context, "rows.db", null, 1);
        //if(mSqLiteDatabase == (null))
        mSqLiteDatabase =  mDatabaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.ROW_NAME_COLUMN, objName);
        values.put(DataBaseHelper.ID_COLUMN, objId);

        mSqLiteDatabase.insert("rows", null, values);
        mSqLiteDatabase.close();
    }

    public static void onObjDel(Context context, String objId) {
        mDatabaseHelper = new DataBaseHelper(context, "rows.db", null, 1);
        mSqLiteDatabase =  mDatabaseHelper.getWritableDatabase();

        mSqLiteDatabase.execSQL("DELETE FROM "+ "rows" + " WHERE " + "_obj_id" + " = " + "'" + objId + "'");

        mSqLiteDatabase.close();
    }

    public static ArrayList<MyObj> fetchMyObjList(Context context){
        mDatabaseHelper = new DataBaseHelper(context, "rows.db", null, 1);
        mSqLiteDatabase =  mDatabaseHelper.getWritableDatabase();

        ArrayList<MyObj> myObjList = new ArrayList<MyObj>();

        Cursor cursor = mSqLiteDatabase.query("rows", new String[] {
                        DataBaseHelper.ROW_NAME_COLUMN, DataBaseHelper.ID_COLUMN},
                null, null,
                null, null, null);

        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            //String rowName = cursor.getString(cursor.getColumnIndex(DataBaseHelper.ROW_NAME_COLUMN));
            String objIdString = cursor.getString(cursor.getColumnIndex(DataBaseHelper.ID_COLUMN));
            MyObj newObj = new MyObj(objIdString);
            myObjList.add(newObj);
        }
        cursor.close();

        return myObjList;
    }
}
