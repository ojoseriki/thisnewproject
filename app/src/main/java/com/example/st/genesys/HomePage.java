package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    Button  service,goods,home,log,product,myacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        home =(Button) findViewById(R.id.home_btn);
        goods =(Button) findViewById(R.id.gooda_btn);
        service= (Button) findViewById(R.id.service_btn);
        product =(Button) findViewById(R.id.product_btn);
        myacc =(Button) findViewById(R.id.account_btn);
        log =(Button) findViewById(R.id.logout_btn);

        log.setOnClickListener(this);
        product.setOnClickListener(this);
        myacc.setOnClickListener(this);
        service.setOnClickListener(this);
        goods.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_btn:
                startActivity(new Intent(HomePage.this,HomePage.class));
                break;
            case R.id.gooda_btn:
                startActivity(new Intent(HomePage.this,goodsPage.class));
                break;
            case  R.id.product_btn:
                startActivity(new Intent(HomePage.this, productivityPage.class));
                break;
            case R.id.service_btn:
                startActivity(new Intent(HomePage.this,servicePage.class));
                break;
            case R.id.account_btn:
                startActivity(new Intent(HomePage.this,myaccountPage.class));

                break;
            case R.id.logout_btn:
                startActivity(new Intent(HomePage.this,LoginPage.class));
                break;


        }
    }
}
