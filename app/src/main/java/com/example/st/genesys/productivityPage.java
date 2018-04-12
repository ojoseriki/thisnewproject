package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class productivityPage extends AppCompatActivity {
    private Button sumit,main;
    private EditText prodctqty,prodcttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivity_page);
        prodctqty = (EditText) findViewById(R.id.prodgood_edit);
        prodcttime = (EditText) findViewById(R.id.prodtime_edit);
        sumit = (Button) findViewById(R.id.prodsub_btn);

        sumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int proqutnty = Integer.parseInt(prodctqty.getText().toString());
                int protime =Integer.parseInt(prodcttime.getText().toString());

                int sumer = proqutnty +0 ;
                int timesum = protime + 0;

                Intent intent = new Intent(productivityPage.this, productivitygraph.class);
                intent.putExtra("Total Goods", sumer);
                intent.putExtra("Total Time", timesum);
                startActivity(intent);

            }
        });
    }
}
