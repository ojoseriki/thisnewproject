package com.example.st.genesys;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.st.genesys.dataLayer.DatabaseHelper;
import com.example.st.genesys.dataLayer.entities.Company;

public class companySignup extends AppCompatActivity {
    SQLiteDatabase db;
    Button company_btn;
    EditText compaddress, compName,Regcode,type,copass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_signup);

        db = DatabaseHelper.getInstance(this);

        compName = (EditText) findViewById(R.id.etcompname);
        compaddress = (EditText) findViewById(R.id.etcompAddress);
        Regcode = (EditText) findViewById(R.id.etcompcode);
        type = (EditText) findViewById(R.id.combusitype);
        copass = (EditText) findViewById(R.id.compassword);
        company_btn = (Button) findViewById(R.id.comsignup);


        addDatacom();

    }
    public void addDatacom(){

        company_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Company company = new Company(compName.getText().toString(),compaddress.getText().toString(),
                        Regcode.getText().toString(), type.getText().toString(),copass.getText().toString());
                long result = Company.create(companySignup.this, company);



                if(result != -1)
                    Toast.makeText(companySignup.this,"Sign UP Successful",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(companySignup.this,"Sign up not Successful", Toast.LENGTH_LONG).show();

            }

        });
    }
}
