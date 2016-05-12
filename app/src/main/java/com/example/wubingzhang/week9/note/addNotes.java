package com.example.wubingzhang.week9.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wubingzhang.week9.R;

import java.util.ArrayList;

public class addNotes extends AppCompatActivity {
    Button backToNotes;
    ArrayList<noteClass> list = new ArrayList<noteClass>();
    EditText label,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        backToNotes = (Button)findViewById(R.id.backToNote);
        backToNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                label = (EditText)findViewById(R.id.nameOfNote);
                content = (EditText)findViewById(R.id.contentOfNote);
                String title = label.getText().toString();
                String context = content.getText().toString();
                noteClass note = new noteClass(title,context);
                Intent intent = new Intent(addNotes.this,notes.class);
                Log.i("xxxx",note.getTitle());
                //Bundle bundle = new Bundle();
                intent.putExtra("note", note);
                //intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                //startActivity(intent);
                finish();
            }
        });
    }
}
