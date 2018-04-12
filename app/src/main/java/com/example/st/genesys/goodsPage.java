package com.example.st.genesys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class goodsPage extends AppCompatActivity {
   EditText quntit, pricein,date_on,duration_time;
   Button good_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_page);

        quntit = (EditText) findViewById(R.id.quntity_good);
        pricein = (EditText) findViewById(R.id.price_good);
        duration_time = (EditText) findViewById(R.id.time_goods);
        date_on = (EditText) findViewById(R.id.date_good);
        good_sub = (Button) findViewById(R.id.submit_goods);

        good_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quntit1 = Integer.parseInt(quntit.getText().toString());
                int pricein1 = Integer.parseInt(pricein.getText().toString());
                int time_wok = Integer.parseInt(duration_time.getText().toString());

                Intent intent = new Intent(goodsPage.this,goodgraph.class);
                intent.putExtra("Total goods", quntit1);
                intent.putExtra("Total price", pricein1);
                intent.putExtra("Duration Worked", time_wok );

                startActivity(intent);
            }
        });
    }
}
