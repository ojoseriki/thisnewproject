package com.example.st.genesys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class goodgraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodgraph);
        LineChart chart = findViewById(R.id.line_chart2);

        int goodsqunti = getIntent().getIntExtra("Total goods",0);
        int goodprice = getIntent().getIntExtra("Total price",0);
        int time = getIntent().getIntExtra("Duration Worked", 0);

        Log.e("DATA", String.format("Total goods %d, Duration Worked %d",goodsqunti,time));

        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0,0));
        entries.add(new Entry(goodsqunti,time));

        LineDataSet line = new LineDataSet(entries, "quantity of Goods sold VS hours worked");
        LineData data = new LineData(line);

        chart.setData(data);
        chart.invalidate();

    }
}
