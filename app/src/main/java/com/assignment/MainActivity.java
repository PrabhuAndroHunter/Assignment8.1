package com.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private Button mAscendBtn;
    private Button mDescendBtn;
    private ArrayAdapter<String> arrayAdapter;
    private ListView mListViw;

    // creating array of month name
    String[] monthName = {"January", "Feb", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initiating laypout
        setContentView(R.layout.activity_main);
        // init views
        initViews();
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_items,R.id.tv,monthName);
        mListViw.setAdapter( arrayAdapter );

        // setting OnClickListener for assigning oder
        mAscendBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort( monthName );
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Months in ascending Oder  ", Toast.LENGTH_SHORT ).show();
                /*this is a toast message
                int LENGTH_SHORT Show the view or text notification for a short period of toast*/

            }
        } );

        // setting OnClickListener for designing oder
        mDescendBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(monthName, Collections.<String>reverseOrder());
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Months in descending Oder", Toast.LENGTH_SHORT ).show();
            }
        } );
    }

    // This method will initialise views
    private void initViews(){
        mAscendBtn =  findViewById( R.id.ascendingBtn );
        mDescendBtn = findViewById( R.id.descendingBtn );
        mListViw = findViewById( R.id.listView );
    }
}

