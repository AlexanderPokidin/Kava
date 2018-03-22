package com.pokidin.a.kava;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class KavaListActivity extends ListActivity {
    private static final String TAG = "KavaListActivity";
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "List started to create");
        ListView listDrinks = getListView();

        try {
            SQLiteOpenHelper kavaDatabaseHelper = new KavaDatabaseHelper(this);
            db = kavaDatabaseHelper.getReadableDatabase();

            cursor = db.query("DRINK",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listDrinks.setAdapter(listAdapter);
            listDrinks.setBackgroundResource(R.color.backgroundColor);
            Log.i(TAG, "List created");
        } catch (SQLiteException e) {
            Log.i(TAG, "DB Exception");
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(KavaListActivity.this, KavaActivity.class);
        intent.putExtra(KavaActivity.EXTRA_KAVANO, (int) id);
        startActivity(intent);
        Log.i(TAG, "Intent started");
    }
}
