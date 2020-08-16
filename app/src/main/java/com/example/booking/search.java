package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class search extends AppCompatActivity {
    ImageView user;
    TextView search,addbooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        user = findViewById(R.id.imageView8);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(search.this, useraccount.class);
                startActivity(intent);
            }
        });
        search = findViewById(R.id.siname2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(search.this, orders.class);
                startActivity(intent);
            }
        });
        addbooks = findViewById(R.id.textView4);
        addbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(search.this, mybooks.class);
                startActivity(intent);
            }
        });
    }
}