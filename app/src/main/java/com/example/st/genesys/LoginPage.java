package com.example.st.genesys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginPage extends AppCompatActivity  {
    Button log ,regis;
   private EditText user,pass;

   private TextView lblIndividual, lblCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = findViewById(R.id.txtUsername);
        pass = findViewById(R.id.txtPassword);
        log =  findViewById(R.id.btnLogin);

        lblIndividual = findViewById(R.id.lblCreateAccount);
        lblCompany = findViewById(R.id.lblCreateCompany);

        lblIndividual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginPage.this, employeeSignup.class));
            }
        });

        lblCompany.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginPage.this, companySignup.class));
            }
        });

log.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        validate(user.getText().toString(),pass.getText().toString());

    }
});

    }

 private void validate( String userName , String userPassword){
       if ((userName.equals("ADMIN")) && (userPassword.equals("1234"))){
    Intent intent = new Intent(LoginPage.this,employerAccess.class);
    startActivity(intent);
       }
       else if ((userName.equals("") && userPassword.equals(""))){
           Intent intent =new Intent(LoginPage.this,HomePage.class);
           startActivity(intent);
       }
 }
}
