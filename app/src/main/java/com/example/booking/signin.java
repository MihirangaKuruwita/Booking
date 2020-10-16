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
   // private FirebaseDatabase firebaseDatabase;
   // private TextView name,email,address,password;
    //private Button update;

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









    }
