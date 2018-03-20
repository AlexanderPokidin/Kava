package com.pokidin.a.kava;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class KavaListActivity extends ListActivity {
    private static final String TAG = "KavaListActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "List started to create");

        ListView listKavas = getListView();
        ArrayAdapter<Kava> listAdapter = new ArrayAdapter<Kava>(
                this, android.R.layout.simple_list_item_1, Kava.kavas);
        listKavas.setAdapter(listAdapter);
        listKavas.setBackgroundResource(R.color.backgroundColor);
        Log.i(TAG, "Adapter started");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(KavaListActivity.this, KavaActivity.class);
        intent.putExtra(KavaActivity.EXTRA_KAVANO, (int) id);
        startActivity(intent);
        Log.i(TAG, "Intent started");
    }
}
