package com.example.wubingzhang.week9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wubingzhang.week9.account.account;
import com.example.wubingzhang.week9.alarm.ClockListActivity;
import com.example.wubingzhang.week9.alarm.HelloActivity;
import com.example.wubingzhang.week9.notes.NoteActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button alarm,notes,account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarm = (Button)findViewById(R.id.alarm);
        notes = (Button)findViewById(R.id.notes);
        account = (Button)findViewById(R.id.account);
        alarm.setOnClickListener(this);
        notes.setOnClickListener(this);
        account.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.alarm:
                intent = new Intent(this, ClockListActivity.class);
                startActivity(intent);
                break;
            case R.id.notes:
                intent = new Intent(this, com.example.wubingzhang.week9.note.notes.class);
                startActivity(intent);
                break;
            case R.id.account:
                intent = new Intent(this, account.class);
                startActivity(intent);
                break;
        }
    }
}
