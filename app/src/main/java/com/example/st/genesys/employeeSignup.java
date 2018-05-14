package com.example.st.genesys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.st.genesys.dataLayer.DatabaseHelper;

public class employeeSignup extends AppCompatActivity {
DatabaseHelper mydb;
 EditText fname,lname,addres,jobdes,emplypassword;
 Button Employsubmit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_signup);

        mydb = new DatabaseHelper(this);
        fname =(EditText)findViewById(R.id.employfname);
        lname = (EditText) findViewById(R.id.employlname);
        addres = (EditText) findViewById(R.id.employaddres);
        jobdes = (EditText) findViewById(R.id.employjobdescription);
        emplypassword = (EditText)findViewById(R.id.employpass);
        Employsubmit_btn = (Button) findViewById(R.id.employsignup_btn);
        addDataEmploy();

    }

    public void addDataEmploy(){
      Employsubmit_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //Add employee to Api Resource
          }
      });

    }
}
