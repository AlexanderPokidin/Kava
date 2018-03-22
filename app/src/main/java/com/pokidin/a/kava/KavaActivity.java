package com.pokidin.a.kava;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KavaActivity extends AppCompatActivity {
    private static final String TAG = "KavaActivity";
    public static final String EXTRA_KAVANO = "kavaNo";

    private int count = 1;
    private int priceNum;
    private String nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kava);
        Log.i(TAG, "onCreate started");

        int kavaNo = (Integer) getIntent().getExtras().get(EXTRA_KAVANO);

        try {
            SQLiteOpenHelper kavaDatabaseHelper = new KavaDatabaseHelper(this);
            SQLiteDatabase db = kavaDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "PRICE", "IMAGE_RESOURCE_ID", "DESCRIPTION_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(kavaNo)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                nameText = cursor.getString(0);
                priceNum = cursor.getInt(1);
                String priceText = Integer.toString(priceNum);
                int imageId = cursor.getInt(2);
                int descriptionId = cursor.getInt(3);

                TextView name = (TextView) findViewById(R.id.item_name);
                name.setText(nameText);

                TextView price = (TextView) findViewById(R.id.item_price);
                price.setText(priceText);

                ImageView photo = (ImageView) findViewById(R.id.item_view);
                photo.setImageResource(imageId);
                photo.setContentDescription(nameText);

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionId);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private int calculatePrice(int count) {
        int cost = priceNum * count;
        displayCost(cost);
        Log.i(TAG, "Price is done");
        Log.i(TAG, "Cost is: " + cost);
        return cost;
    }

    public void increment(View view) {
        if (count > 4) {
            Toast maxToast = Toast.makeText(getApplicationContext(),
                    "There is nothing more", Toast.LENGTH_SHORT);
            maxToast.show();
            return;
        }
        count++;
        displayCount(count);
        calculatePrice(count);
    }

    public void decrement(View view) {
        if (count < 2) {
            Toast minToast = Toast.makeText(getApplicationContext(),
                    "There is nothing less", Toast.LENGTH_SHORT);
            minToast.show();
            return;
        }
        count--;
        displayCount(count);
        calculatePrice(count);
    }

    private void displayCount(int count) {
        TextView number = (TextView) findViewById(R.id.item_count);
        number.setText("" + count);
    }

    private void displayCost(int cost) {
        TextView costView = (TextView) findViewById(R.id.cost_text);
        costView.setText("" + cost);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:a.pokidin@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, createOrderSubject());
        intent.putExtra(Intent.EXTRA_TEXT, createOrderMessage());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSubject() {
        EditText editName = (EditText) findViewById(R.id.customer_name);
        String customer_Name = editName.getText().toString();
        String orderSubject = nameText;
        orderSubject += ", for " + customer_Name;
        Log.i(TAG, "Name is: " + customer_Name);
        return orderSubject;
    }

    private String createOrderMessage() {
        String orderMessage = nameText + "\n";
        orderMessage += "Price: " + priceNum + " UAH \n";
        orderMessage += "Count: " + count + "\n";
        orderMessage += "Cost: " + calculatePrice(count) + " UAH";
        Log.i(TAG, "Order is: " + orderMessage);
        return orderMessage;
    }
}
