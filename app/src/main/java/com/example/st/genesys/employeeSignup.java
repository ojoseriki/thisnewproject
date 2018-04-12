package com.example.st.genesys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class employeeSignup extends AppCompatActivity {
DatabaseHelper mydb;
 EditText fname,lname,addres,jobdes,emplypassword,Employcode;
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
        Employcode = (EditText) findViewById(R.id.employcode);
        Employsubmit_btn = (Button) findViewById(R.id.employsignup_btn);
        addDataEmploy();

    }

    public void addDataEmploy(){
      Employsubmit_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              boolean insertDATAemploy1 = mydb.insertDATAemploy(fname.getText().toString(),lname.getText().toString(),addres.getText().toString(),jobdes.getText().toString()
                      , emplypassword.getText().toString(),Integer.parseInt(Employcode.getText().toString()));

              if (insertDATAemploy1 = true){
                  Toast.makeText(employeeSignup.this,"Sign up is successful",Toast.LENGTH_LONG ).show();
              }else
                  Toast.makeText(employeeSignup.this,"sign UP NOT successful", Toast.LENGTH_LONG).show();
          }
      });

    }
}
