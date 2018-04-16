package com.example.st.genesys.dataLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.st.genesys.dataLayer.entities.Company;
import com.example.st.genesys.dataLayer.entities.Employee;

/**
 * Created by st on 2018/04/12.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static SQLiteDatabase db;

    public static final String DATABASE_GENESYS = "Genesysdb.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_GENESYS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Company.getCreateStatement());
        db.execSQL(Employee.getCreateStatement());

        inserDataCom(db,"Seriki", "50 VUT Street", "CODE12", "MyType", "password1");
        insertDATAemploy(db,"Simon", "Hlengani", "simon@iamrivalani.co.za", "Developer", "simon@pass", 1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Company.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Employee.TABLE);
        onCreate(db);
    }

    public boolean inserDataCom(SQLiteDatabase db,String name, String address, String code, String type, String pass) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(Company.NAME, name);
        contentValues.put(Company.ADDRESS, address);
        contentValues.put(Company.COMPANY_CODE, code);
        contentValues.put(Company.BUSINESS_TYPE, type);
        contentValues.put(Company.PASSWORD, pass);
        Long result = db.insert(Company.TABLE, null, contentValues);

        if (result == -1)
            return false;
        else

            return true;

    }
    public  boolean insertDATAemploy(SQLiteDatabase db, String fname, String lname, String adres,String job, String pass, Integer Emcode)  {
        ContentValues contentemploy = new ContentValues();
        contentemploy.put(Employee.FIRST_NAME,fname);
        contentemploy.put(Employee.LAST_NAME,lname);
        contentemploy.put(Employee.ADDRESS,adres);
        contentemploy.put(Employee.JOB_DESCRIPTION,job);
        contentemploy.put(Employee.PASSWORD,pass);
        contentemploy.put(Employee.EMPLOYER_CODE,Emcode);

        long result1 =db.insert(Employee.TABLE,null,contentemploy);
        if (result1 == -1)
            return  false;
        else
            return  true;
    }

    public static SQLiteDatabase getInstance(Context context)
    {
        if(db == null)
        {
            db = new DatabaseHelper(context).getWritableDatabase();

        }
        return db;
    }

}