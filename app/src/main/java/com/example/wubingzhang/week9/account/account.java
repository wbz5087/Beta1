package com.example.wubingzhang.week9.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wubingzhang.week9.R;


import java.text.SimpleDateFormat;
import java.util.Date;

public class account extends AppCompatActivity {
    Button viewAnalysis;
    Date date;
    String dateStr = "";
    String type;
    float cost = 0;
    EditText addCost;
    Button food,shopping,study,entertain,fee,transport,save;
    TextView dateInfo,oneDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setDateInfo();

        addCost = (EditText)findViewById(R.id.addCost);
        food = (Button)findViewById(R.id.food);
        shopping = (Button)findViewById(R.id.shopping);
        study = (Button)findViewById(R.id.study);
        entertain = (Button)findViewById(R.id.entertain);
        fee = (Button)findViewById(R.id.fee);
        transport = (Button)findViewById(R.id.transport);
        save = (Button)findViewById(R.id.saveCost);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addInfo();
            }
        });


        viewAnalysis = (Button)findViewById(R.id.analysis);
        viewAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this,viewAnalysis.class);
                startActivity(intent);
                account.this.finish();
            }
        });
    }

    private void addInfo(){
        cost += Float.parseFloat(addCost.getText().toString());

        food.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                type = "food";
            }
        });
        shopping.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                type = "shopping";
            }
        });
        study.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                type = "study";
            }
        });
        entertain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                type = "entertain";
            }
        });
        transport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                type = "transport";
            }
        });
        fee.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                type = "fee";
            }
        });

        accountClass accountClass = new accountClass(cost,type,date);
        setDateInfo();
    }

    private void setDateInfo(){
        SimpleDateFormat sDateFormat = new  SimpleDateFormat("yyyy-MM-dd");
        date = new Date(System.currentTimeMillis());
        dateStr =  sDateFormat.format(date);
        dateInfo = (TextView)findViewById(R.id.dateInfo);
        oneDay = (TextView)findViewById(R.id.oneDay);
        dateInfo.setText(dateStr);
        oneDay.setText(Float.toString(cost));
    }
}
