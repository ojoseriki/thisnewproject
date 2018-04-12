package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginPage extends AppCompatActivity  {
    Button log ,regis;
   private EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        regis = (Button) findViewById(R.id.register_btn);
        user = (EditText) findViewById(R.id.user_edit);
        pass = (EditText) findViewById(R.id.passowrd_edit);
        log = (Button) findViewById(R.id.login_btn);

     regis.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         Intent intent = new Intent(LoginPage.this,DecidePage.class);
         startActivity(intent);

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
