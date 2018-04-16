package com.example.st.genesys.dataLayer.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.st.genesys.dataLayer.DatabaseHelper;

/**
 * Created by codethunder on 2018/04/13.
 */

public class Company {

    public static final String TABLE = "Company_table";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String COMPANY_CODE = "COMPANY_CODE";
    public static final String BUSINESS_TYPE = "BUSINESS_TYPE";
    public static final String PASSWORD = "PASSWORD";

    private int id;
    private String name;
    private String address;
    private String companyCode;
    private String businessType;
    private String password;

    public Company(String name, String address, String companyCode, String businessType, String password) {
        this.name = name;
        this.address = address;
        this.companyCode = companyCode;
        this.businessType = businessType;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public static long create(Context context, Company company)
    {
        SQLiteDatabase db = DatabaseHelper.getInstance(context);

        ContentValues values = new ContentValues();
        values.put(NAME, company.getName());
        values.put(ADDRESS, company.getName());
        values.put(COMPANY_CODE, company.getCompanyCode());
        values.put(BUSINESS_TYPE, company.getBusinessType());
        values.put(PASSWORD, company.getPassword());

        return db.insert(TABLE,null, values);

    }

    public static String getCreateStatement()
    {
        String statement = " CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL,"
                                +"%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)";

        return String.format(statement, TABLE, ID, NAME, ADDRESS, COMPANY_CODE, BUSINESS_TYPE, PASSWORD);
    }

}
