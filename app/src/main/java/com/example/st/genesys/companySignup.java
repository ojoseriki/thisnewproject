package com.example.st.genesys;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class companySignup extends AppCompatActivity {
    DatabaseHelper mydb;
    Button company_btn;
    EditText compaddress, compName,Regcode,type,copass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_signup);

        mydb = new DatabaseHelper(this);

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
                boolean insertDataCom = mydb.inserDataCom(compName.getText().toString(), compaddress.getText().toString(), Regcode.getText().toString(),type.getText().toString(), copass.getText().toString());

                if(insertDataCom=true)
                    Toast.makeText(companySignup.this,"Sign UP Successful",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(companySignup.this,"Sign up not Successful", Toast.LENGTH_LONG).show();

            }

        });
    }
}
