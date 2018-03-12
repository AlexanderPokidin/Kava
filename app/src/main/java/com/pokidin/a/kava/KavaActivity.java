package com.pokidin.a.kava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class KavaActivity extends AppCompatActivity {
    private static final String TAG = "KavaActivity";
    public static final String EXTRA_KAVANO = "kavaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kava);
        Log.i(TAG, "onCreate started");

        int kavaNo = (Integer) getIntent().getExtras().get(EXTRA_KAVANO);
        Kava kava = Kava.kavas[kavaNo];
        Log.i(TAG, "Intent was read");

        TextView name = (TextView) findViewById(R.id.item_name);
        name.setText(kava.getName());
        Log.i(TAG, "Name is done");

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(kava.getDescription());
        Log.i(TAG, "Description is done");

        ImageView photo = (ImageView) findViewById(R.id.item_view);
        photo.setImageResource(kava.getImageResourceId());
        photo.setContentDescription(kava.getName());
        Log.i(TAG, "Image is done");

        TextView price = (TextView) findViewById(R.id.item_price);
        price.setText("" + kava.getPrice());
        Log.i(TAG, "Price is done");
    }
}
