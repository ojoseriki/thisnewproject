package com.example.st.genesys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.st.genesys.dataLayer.DatabaseHelper;
import com.example.st.genesys.dataLayer.entities.Employee;

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
              Employee employee = new Employee(fname.getText().toString(), lname.getText().toString(),
                      addres.getText().toString(), jobdes.getText().toString(), emplypassword.getText().toString(),
                      Integer.parseInt(Employcode.getText().toString()));

              long result = Employee.create(employeeSignup.this,employee);

              if (result != -1){
                  Toast.makeText(employeeSignup.this,"Sign up is successful",Toast.LENGTH_LONG ).show();
              }else
                  Toast.makeText(employeeSignup.this,"sign UP NOT successful", Toast.LENGTH_LONG).show();
          }
      });

    }
}
