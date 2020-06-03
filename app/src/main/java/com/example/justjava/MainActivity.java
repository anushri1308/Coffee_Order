package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {
        TextView obj1 = (TextView) findViewById(R.id.order_text);
        TextView obj2 = (TextView) findViewById(R.id.price);
        EditText obj3 = (EditText) findViewById(R.id.name);
        Button obj4 = (Button) findViewById(R.id.order_button);
        Button obj5 = (Button) findViewById(R.id.Reset_button);
        String chk = "" + obj3.getText();
        if (quantity == 0) {
            Toast.makeText(getApplicationContext(), "Order at least one coffee please :)", 5).show();
        }
        else if (!chk.equalsIgnoreCase("")) {
            obj2.setText("Your Order Summary");
            obj1.setText("Thank You For Placing Order" + createOrderSummary());
            obj4.setVisibility(View.INVISIBLE);
            obj5.setText("Place New Order");
            Toast.makeText(getApplicationContext(), "Your order has been placed", 5).show();
        } else {
            Toast.makeText(getApplicationContext(), "Enter Customer's Name-)", 5).show();
        }
    }

    public void increment(View view) {
        quantity = quantity + 1;
        price = price + 5;
        display();
        change1();
        displayPriceOnClick();
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            price = price - 5;
            display();
            change2();
            displayPriceOnClick();
        }

    }

    public void checkbox1(View view) {
        CheckBox obj1 = (CheckBox) findViewById(R.id.checkbox1);
        boolean f = obj1.isChecked();
        if (f) {
            price = price + (quantity * 1);
        } else {
            price = price - (quantity * 1);
        }
        if (price < 0) {
            price = 0;
        }
        displayPriceOnClick();
    }

    public void checkbox2(View view) {
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean f1 = obj2.isChecked();
        if (f1) {
            price = price + (quantity * 2);
        } else {
            price = price - (quantity * 2);
        }
        if (price < 0) {
            price = 0;
        }
        displayPriceOnClick();
    }

    private void chkboxs() {
        CheckBox obj1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean f = obj1.isChecked();
        if (f) {
            price = price + (quantity * 1);
        }
        boolean f1 = obj2.isChecked();
        if (f1) {
            price = price + (quantity * 2);
        }
    }

    private void change1() {
        CheckBox obj1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean f = obj1.isChecked();
        if (f) {
            price = price + 1;
        }
        boolean f1 = obj2.isChecked();
        if (f1) {
            price = price + 2;
        }
    }

    private void change2() {
        CheckBox obj1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean f = obj1.isChecked();
        if (f) {
            price = price - 1;
        }
        boolean f1 = obj2.isChecked();
        if (f1) {
            price = price - 2;
        }
    }

    public void Reset(View view) {
        quantity = 0;
        price = 0;
        TextView obj2 = (TextView) findViewById(R.id.price);
        EditText obj3 = (EditText) findViewById(R.id.name);
        Button obj4 = (Button) findViewById(R.id.order_button);
        Button obj5 = (Button) findViewById(R.id.Reset_button);
        obj3.setText("");
        obj2.setText("Price");
        obj4.setVisibility(View.VISIBLE);
        obj5.setText("Reset");
        display();
        chkboxs();
        displayPriceOnClick();
    }


    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayPriceOnClick() {
        TextView quantityTextView = (TextView) findViewById(R.id.order_text);
        quantityTextView.setText("Rs " + price);
    }

    private String createOrderSummary() {
        CheckBox obj1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox obj2 = (CheckBox) findViewById(R.id.checkbox2);
        EditText obj3 = (EditText) findViewById(R.id.name);
        String text = "Name- " + obj3.getText() + "\n";
        boolean f = obj1.isChecked();
        boolean f1 = obj2.isChecked();
        if (f) {
            text = text + " Added whipped cream\n";
        } else {
            text = text + " Not added whipped cream\n";
        }
        if (f1) {
            text = text + " Added chocolate chips\n";
        } else {
            text = text + " Not added chocolate chips\n";
        }
        text = text + " Quantity- " + quantity;
        text = text + "\n Price- Rs " + price;
        return text;
    }

}