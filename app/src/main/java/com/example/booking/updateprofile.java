package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updateprofile extends AppCompatActivity {

    private EditText newUsername,newUseraddrees,newUsereemail,newpassword;
    //private TextView newUsereemail,newpassword;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private  FirebaseDatabase firebaseDatabase;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        newUsername = findViewById(R.id.upname1);
        newUsereemail = findViewById(R.id.upemail1);
        newUseraddrees = findViewById(R.id.upaddress1);
        newpassword = findViewById(R.id.upPassword1);
        save=findViewById(R.id.upbuttonup1);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        rootNode = FirebaseDatabase.getInstance();
        reference  = rootNode.getReference(firebaseAuth.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userprofile userprofile = dataSnapshot.getValue(userprofile.class);
                newUsername.setText(userprofile.getUsername());
                newUsereemail.setText(userprofile.getUserEmail());
                newUseraddrees.setText(userprofile.getUserAddress());
                newpassword.setText(userprofile.getUserPassword());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateprofile.this, databaseError.getCode(), Toast.LENGTH_SHORT);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newUsername.getText().toString();
                String email = newUsereemail.getText().toString();
                String address = newUseraddrees.getText().toString();
                String password=newpassword.getText().toString();

                userprofile Userprofile = new userprofile(name,email,address,password);

               reference.setValue(Userprofile);
                startActivity(new Intent(updateprofile.this,search.class));
                finish();

            }
        });
       /* save.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
              startActivity(new Intent(updateprofile.this,updateprofile.class));
        }
        });

        */


    }
}
