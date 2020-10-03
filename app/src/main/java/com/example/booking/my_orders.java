package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class my_orders extends AppCompatActivity {

    private TextView note,pick;

    //private EditText pick;

    private FirebaseAuth firebaseAuth;
    private  FirebaseDatabase firebaseDatabase;


    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        pick = findViewById(R.id.picknote);
        note = findViewById(R.id.id6);

/*
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        rootNode = FirebaseDatabase.getInstance();
        reference  = rootNode.getReference("note");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                noteupdate noteupdate = dataSnapshot.getValue(noteupdate.class);
                pick.setText(noteupdate.getNote());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(my_orders.this, databaseError.getCode(), Toast.LENGTH_SHORT);
            }
        });

 */


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("note");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                noteupdate noteupdate = dataSnapshot.getValue(noteupdate.class);
                pick.setText(noteupdate.getNote());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(my_orders.this, databaseError.getCode(), Toast.LENGTH_SHORT);
            }
        });


        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(my_orders.this, note.class);
                startActivity(intent);
            }
        });



    }
}