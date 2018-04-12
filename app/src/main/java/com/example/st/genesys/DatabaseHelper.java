package com.example.st.genesys;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by st on 2018/04/12.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_GENESYS = "Genesysdb.db";
    //TABLE COMPANY
    public static final String TABLE_COMPANY = "Company_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "COMPANY_CODE";
    public static final String COL_5 = "BUSINESS_TYPE";
    public static final String COL_6 = "PASSWORD";
    // TABLE EMPLOYEE
    public static final String TABLE_EMPLOYEE = "Employee_table";
    public static final String COL_7 = "ID";
    public static final String COL_8 = "FIRSTNAME";
    public static final String COL_9 = "LASTNAME";
    public static final String COL_10 = "ADDRESS";
    public static final String COL_11 = "JOB_DESCRIBTION ";
    public static final String COL_12 = "PASSWORD";
    public static final String COL_13 = "EMPLOYER_CODE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_GENESYS, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_COMPANY + "( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `NAME` TEXT NOT NULL, `ADDRESS` TEXT NOT NULL, `REGISTRATION_CODE` TEXT NOT NULL, `BUSINESS_TYPE` TEXT NOT NULL, `PASSWORD` TEXT NOT NULL )");
        db.execSQL("create table " + TABLE_EMPLOYEE + "( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `FIRSTNAME` TEXT NOT NULL, `LASTNAME` TEXT NOT NULL, `ADDRESS` TEXT NOT NULL, `PASSWORD` TEXT NOT NULL, `EMPLOYEE_CODE` INTEGER NOT NULL, FOREIGN KEY(`EMPLOYEE_CODE`) REFERENCES `Company`(`ID`) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }

    public boolean inserDataCom(String name, String address, String code, String type, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, address);
        contentValues.put(COL_4, code);
        contentValues.put(COL_5, type);
        contentValues.put(COL_6, pass);
        Long result = db.insert(TABLE_COMPANY, null, contentValues);

        if (result == -1)
            return false;
        else

            return true;

    }
    public  boolean insertDATAemploy( String fname, String lname, String adres,String job, String pass, Integer Emcode)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentemploy = new ContentValues();
        contentemploy.put(COL_8,fname);
        contentemploy.put(COL_9,lname);
        contentemploy.put(COL_10,adres);
        contentemploy.put(COL_11,job);
        contentemploy.put(COL_12,pass);
        contentemploy.put(COL_13,Emcode);
        long result1 =db.insert(TABLE_EMPLOYEE,null,contentemploy);
        if (result1 == -1)
            return  false;
        else
            return  true;
    }
}