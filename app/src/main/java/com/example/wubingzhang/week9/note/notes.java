package com.example.wubingzhang.week9.note;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wubingzhang.week9.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class notes extends AppCompatActivity {
    private ListView notesList;
    ArrayList<noteClass> list = new ArrayList<noteClass>();
    Button addNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        addNotes = (Button)findViewById(R.id.addNotes);
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notes.this, com.example.wubingzhang.week9.note.addNotes.class);
                startActivityForResult(intent, 1);
                // finish();
            }
        });


        noteClass note1 = new noteClass("1","2");
        list.add(note1);
        //getData();
        populateList();
    }

    private void populateList(){
        notesList = (ListView)findViewById(R.id.notesList);

        notesAdapter adapter = new notesAdapter(this,R.layout.notes_cell,list);

        notesList.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent){

        Serializable extra = intent.getSerializableExtra("note");
        if(extra!=null){
            noteClass note = (noteClass)extra;
            //note2.setTitle(note.getTitle());
            list.add(note);
        }

        populateList();
    }

    static class ViewHolder{
        public TextView title;
        public TextView content;
    }

    public void getData(){
        Serializable extra = getIntent().getSerializableExtra("note");
        if(extra!=null){
            noteClass note = (noteClass)extra;
            list.add(note);
        }
    }

    public class notesAdapter extends ArrayAdapter<noteClass> {

        private int layoutResource;

        public notesAdapter(Context context, int layoutResource, List<noteClass> noteList) {
            super(context, layoutResource, noteList);
            this.layoutResource = layoutResource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                view = layoutInflater.inflate(layoutResource, null);
            }

            noteClass note = getItem(position);

            if (note != null) {
                TextView label = (TextView) view.findViewById(R.id.noteLabel);
                TextView content = (TextView) view.findViewById(R.id.noteContent);

                if (label != null) {
                    label.setText(note.getTitle());
                }

                if (content != null) {
                    content.setText(note.getContent());
                }

            }

            return view;
        }

    }
}

