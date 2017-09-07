package com.example.deepi.fiesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Deepi on 2/11/2017.
 */
public class AppHelper extends SQLiteOpenHelper {
    Context context=null;

    public AppHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AppConstants.LOGIN_CREATE);
        //sqLiteDatabase.execSQL(AppConstants.QUERY);
        sqLiteDatabase.execSQL(AppConstants.QUERYY);
        sqLiteDatabase.execSQL(AppConstants.QUERYYWEDDING);
        sqLiteDatabase.execSQL(AppConstants.QUERYYBOOKING);
        sqLiteDatabase.execSQL(AppConstants.QUERYYBOOKID);
        //Toast.makeText(context,"table created", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Log.w("SingleDBAdapter", "Upgrading database from version " + i
                + " to "
                + i1 + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ AppConstants.LOGINTABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ AppConstants.TABLE_MNAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ AppConstants.TABLE_WEDDING);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ AppConstants.TABLE_BOOK);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ AppConstants.TABLE_BOOKIDD);
        onCreate(sqLiteDatabase);




    }

}
