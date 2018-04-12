package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DecidePage extends AppCompatActivity implements View.OnClickListener {
    Button but ,but2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide_page);
        but= (Button)  findViewById(R.id.button);
        but2 = (Button) findViewById(R.id.button2);

        but2.setOnClickListener(this);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                startActivity(new Intent(DecidePage.this,companySignup.class));
                break;
            case R.id.button2:
                startActivity(new Intent(DecidePage.this,employeeSignup.class));
                break;
        }
    }
}
