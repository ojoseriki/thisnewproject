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

public class productivitygraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivitygraph);

        LineChart chart = findViewById(R.id.line_chart1);

        int qunatityPro = getIntent().getIntExtra("Total Goods",0);
        int timepro = getIntent().getIntExtra("Total Time",0);


        Log.e("DATA", String.format("Total Goods %d, Total Time %d",qunatityPro,timepro));
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0,0));
        entries.add(new Entry(qunatityPro,timepro));

        LineDataSet line = new LineDataSet(entries, "Production Quantity VS Time worked");
        LineData data = new LineData(line);

        chart.setData(data);
        chart.invalidate();

    }
}
