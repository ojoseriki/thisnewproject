package com.example.st.genesys.dataLayer.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.st.genesys.dataLayer.DatabaseHelper;

/**
 * Created by codethunder on 2018/04/13.
 */

public class Employee {

    public static final String TABLE = "Employee_table";
    public static final String ID = "ID";
    public static final String FIRST_NAME = "FIRSTNAME";
    public static final String LAST_NAME = "LASTNAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String JOB_DESCRIPTION = "JOB_DESCRIPTION ";
    public static final String PASSWORD = "PASSWORD";
    public static final String EMPLOYER_CODE = "COMPANY_CODE";

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String jobDescription;
    private String password;
    private int companyCode;

    public Employee(String firstName, String lastName, String address, String jobDescription, String password, int companyCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.jobDescription = jobDescription;
        this.password = password;
        this.companyCode = companyCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addres) {
        this.address = address;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public static long create(Context context, Employee employee)
    {
        SQLiteDatabase db = DatabaseHelper.getInstance(context);

        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, employee.getFirstName());
        values.put(LAST_NAME, employee.getLastName());
        values.put(ADDRESS, employee.getAddress());
        values.put(JOB_DESCRIPTION, employee.getJobDescription());
        values.put(PASSWORD, employee.getPassword());
        values.put(EMPLOYER_CODE, employee.getCompanyCode());

        return db.insert(TABLE,null, values);

    }
    public static String getCreateStatement()
    {
        String statement = " CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL,"
                +"%s TEXT NOT NULL, %s TEXT NOT NULL,%s TEXT NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY (%s) REFERENCES %s(%s))";

        return String.format(statement, TABLE, ID, FIRST_NAME, LAST_NAME, ADDRESS, JOB_DESCRIPTION, PASSWORD
                , EMPLOYER_CODE, EMPLOYER_CODE, Company.TABLE, Company.ID);
    }
}

