package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView header;
    ListView userList;
    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        db=dbHelper.getReadableDatabase();
        cursor=db.rawQuery("select * from "+DBHelper.TABLE,null);
        String [] haeders={DBHelper.COLUMN_NAME,DBHelper.COLUMN_AGE};
        adapter=new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,haeders,new int[]{android.R.id.text1,android.R.id.text2},0);
        header.setText("Count elements in DB "+String.valueOf(cursor.getCount()));
        userList.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header=findViewById(R.id.head);
        userList=findViewById(R.id.list_user);
        dbHelper= new DBHelper(getApplicationContext());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
        cursor.close();
    }
}
