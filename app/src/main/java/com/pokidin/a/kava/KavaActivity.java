package com.pokidin.a.kava;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kava);
        Log.i(TAG, "onCreate started");

//        int kavaNo = (Integer) getIntent().getExtras().get(EXTRA_KAVANO);
//        Kava kava = Kava.kavas[kavaNo];

        TextView name = (TextView) findViewById(R.id.item_name);
        name.setText(readIntent().getName());
        Log.i(TAG, "Name is done");

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(readIntent().getDescription());
        Log.i(TAG, "Description is done");

        ImageView photo = (ImageView) findViewById(R.id.item_view);
        photo.setImageResource(readIntent().getImageResourceId());
        photo.setContentDescription(readIntent().getName());
        Log.i(TAG, "Image is done");

        TextView price = (TextView) findViewById(R.id.item_price);
        price.setText("" + readIntent().getPrice());
    }

    private Kava readIntent() {
        int kavaNo = (Integer) getIntent().getExtras().get(EXTRA_KAVANO);
        return Kava.kavas[kavaNo];
    }

    private int calculatePrice(int count) {
        int price = readIntent().getPrice();
        int cost = price * count;
        displayCost(cost);
        Log.i(TAG, "Price is done");
        Log.i(TAG, "Cost is: " + cost);
        return cost;
    }

    public void increment(View view) {
        if (count > 4) {
            Toast maxToast = Toast.makeText(getApplicationContext(), "There is nothing more", Toast.LENGTH_SHORT);
            maxToast.show();
            return;
        }
        count++;
        displayCount(count);
        calculatePrice(count);
    }

    public void decrement(View view) {
        if (count < 2) {
            Toast minToast = Toast.makeText(getApplicationContext(), "There is nothing less", Toast.LENGTH_SHORT);
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
        String orderSubject = readIntent().getName();
        orderSubject += ", for " + customer_Name;
        Log.i(TAG, "Name is: " + customer_Name);
        return orderSubject;
    }

    private String createOrderMessage() {
        int price = readIntent().getPrice();
        String orderMessage = readIntent().getName() + "\n";
        orderMessage += readIntent().getSize() + "\n";
        orderMessage += price + "\n";
        orderMessage += count + "\n";
        orderMessage += calculatePrice(count);
        Log.i(TAG, "Order is: " + orderMessage);
        return orderMessage;
    }
}
