package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class mybooks extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private EditText bname1,author1,selling1;
    private Button publish;
    private ImageView delete;

    private  FirebaseDatabase firebaseDatabase;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybooks);

        bname1 = findViewById(R.id.bname);
        author1 = findViewById(R.id.author);
        selling1 = findViewById(R.id.selling);
        publish = findViewById(R.id.publish);
        delete = findViewById(R.id.imageView3);

                //data upload
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

                //save data in realtime database
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Book");

                //get all the values

                publish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String bname = bname1.getText().toString();
                        String author = author1.getText().toString();
                        String selling = selling1.getText().toString();


                        book book = new book(bname, author, selling);

                        reference.child(bname).setValue(book);


                        Intent intent = new Intent(mybooks.this, search.class);
                        startActivity(intent);

                        Toast.makeText(mybooks.this,"Your book added to the store",Toast.LENGTH_SHORT ).show();
                    }
                });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
                //databaseReference.removeValue();
                startActivity(new Intent(mybooks.this,search.class));
            }
        });

            }









    }

