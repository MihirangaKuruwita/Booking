package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class useraccount extends AppCompatActivity {
    private TextView textView3,name,email,address,password,deleteu;
    private Button update;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useraccount);
        textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(useraccount.this, mybooks.class);
                startActivity(intent);
            }
        });
        //Hooks
        name = findViewById(R.id.siname1);
        email = findViewById(R.id.siemail1);
        address = findViewById(R.id.siaddress1);
        password = findViewById(R.id.siPassword1);
        update = findViewById(R.id.buttonup1);
        deleteu = findViewById(R.id.textView2);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userprofile userprofile = dataSnapshot.getValue(userprofile.class);
                name.setText(userprofile.getUsername());
                email.setText(userprofile.getUserEmail());
                address.setText(userprofile.getUserAddress());
                password.setText(userprofile.getUserPassword());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(useraccount.this, databaseError.getCode(), Toast.LENGTH_SHORT);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(useraccount.this,updateprofile.class));
            }
        });
        deleteu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
                databaseReference.removeValue();
                Toast.makeText(useraccount.this,"Your account removed",Toast.LENGTH_SHORT ).show();
                startActivity(new Intent(useraccount.this,MainActivity.class));

            }
        });

     

   /*    //show all data
         showAllUserData();



    }

   private void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_userEmail = intent.getStringExtra("email");
        String user_userAddress = intent.getStringExtra("address");
        String user_userPassword = intent.getStringExtra("password");

        name.setText(user_username);
        email.setText(user_userEmail);
        address.setText(user_userAddress);
        password.setText(user_userPassword);

    */
        }




}