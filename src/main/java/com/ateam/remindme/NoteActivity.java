package com.ateam.remindme;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ateam.remindme.adapters.ItemsArrayAdapters;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {

    ArrayList<String> mItems;
    ItemsArrayAdapters mItemsArrayAdapter;
    EditText mEdit;
    ListView mItemListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        getSupportActionBar();
        mItems = new ArrayList<>();
        mItemsArrayAdapter = new ItemsArrayAdapters(this, mItems);
        mItemListView = (ListView)findViewById(R.id.listView);
        mItemListView.setAdapter(mItemsArrayAdapter);
        mItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView item = (TextView)findViewById(R.id.itemText);
                if(item.getPaintFlags() == 16){
                    item.setPaintFlags(item.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                }
                else{
                    item.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });

    }

    public void addItem(View view) {


        LayoutInflater li = LayoutInflater.from(this);
        LinearLayout newBaseLay = (LinearLayout)li.inflate(R.layout.new_item_dialog, null);

        mEdit = (EditText) newBaseLay.getChildAt(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mItems.add(mEdit.getText().toString());
                mItemsArrayAdapter.notifyDataSetChanged();

            }
        });
        builder.setNegativeButton("CANCEL", null)
                .setTitle("New Task");
        builder.setView(newBaseLay);
        builder.show();


    }
}
