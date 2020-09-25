package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class note extends AppCompatActivity {

    private EditText note2;
    private Button addAnote;
    private FirebaseDatabase firebaseDatabase;

    private FirebaseAuth firebaseAuth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        addAnote = findViewById(R.id.button_note);
        note2 = findViewById(R.id.note);

        //data upload
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        //save data in realtime database
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("note");

        addAnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = note2.getText().toString();



                noteupdate noteupdate = new noteupdate(note);

                reference.child(note).setValue(noteupdate);


                Intent intent = new Intent(note.this, my_orders.class);
                startActivity(intent);
            }
        });


    }
}