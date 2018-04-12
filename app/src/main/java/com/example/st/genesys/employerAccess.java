package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class employerAccess extends AppCompatActivity implements View.OnClickListener {
Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_access);
        sub = (Button)findViewById(R.id.clickhere);

        sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
  switch (v.getId()){
      case R.id.clickhere:
          startActivity(new Intent(employerAccess.this, employeeList.class));
          break;
  }
    }
}
