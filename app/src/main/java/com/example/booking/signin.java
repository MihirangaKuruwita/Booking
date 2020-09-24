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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class signin extends AppCompatActivity {
     private Button login;
     private EditText si_email;
     private EditText si_password;
     private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView name,email,address,password;
    private Button update;

     //DatabaseReference reference;
     //FirebaseDatabase rootNode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        si_email = (EditText) findViewById(R.id.editTextTextPersonName);
        si_password = (EditText) findViewById(R.id.editTextTextPassword);
        login = (Button) findViewById(R.id.buttons);


        firebaseAuth = firebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //if(user != null){
        //finish();
        // startActivity(new Intent(signin.this, search.class ));
        // }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(si_email.getText().toString(), si_password.getText().toString());
            }
        });

    }



    private void validate(String si_email,String si_password){

        firebaseAuth.signInWithEmailAndPassword( si_email,si_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(signin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signin.this, search.class));


                }
            else{
                    Toast.makeText(signin.this,"Login Failed",Toast.LENGTH_SHORT ).show();

                }

            }
        });
    }



 /*               name = findViewById(R.id.siname1);
                    email = findViewById(R.id.siemail1);
                    address = findViewById(R.id.siaddress1);
                    password = findViewById(R.id.siPassword1);
                    update = findViewById(R.id.buttonup1);

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
                            Toast.makeText(signin.this, databaseError.getCode(), Toast.LENGTH_SHORT);
                        }
                    });
                }







  private  void isUser(){
        final String userEnteredEmail = si_email.getText().toString().trim();
        final String userEnteredPassword = si_password.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());

       Query checkUser = reference.orderByChild("email").equalTo(userEnteredEmail);

       checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists()){

                   String PasswordFromDB =dataSnapshot.child(userEnteredPassword).child("password").getValue(String.class);

                   if(PasswordFromDB.equals(userEnteredPassword)){
                       String nameFromDB =dataSnapshot.child(userEnteredEmail).child("username").getValue(String.class);
                       String emailFromDB =dataSnapshot.child(userEnteredEmail).child("email").getValue(String.class);
                       String addressFromDB =dataSnapshot.child(userEnteredEmail).child("address").getValue(String.class);
                       //String PasswordFromDB =dataSnapshot.child(userEnteredEmail).child("password").getValue(String.class);

                       Intent intent = new Intent(getApplicationContext(),useraccount.class);

                       intent.putExtra("username",nameFromDB);
                       intent.putExtra("email",emailFromDB);
                       intent.putExtra("address",addressFromDB);
                       intent.putExtra("password",PasswordFromDB);

                       startActivity(intent);

                   }
                   else {
                       si_password.setError("Wrong Password");
                       si_password.requestFocus();
                   }
               }
               else {
                   si_email.setError("No such email exist");
                   si_email.requestFocus();
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
*/
    }
