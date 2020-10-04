package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class signup extends AppCompatActivity {
    private Button login;
    private EditText username,upassword,uemail,uaddress;
    private FirebaseAuth firebaseAuth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupViews();
        firebaseAuth =FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //data upload
                    String user_email = uemail.getText().toString().trim();
                    String user_password = upassword.getText().toString().trim();

                    //save data in realtime database
                    rootNode = FirebaseDatabase.getInstance();
                    reference  = rootNode.getReference(firebaseAuth.getUid());

                    //get all the values
                    String name = username.getText().toString();
                    String password = upassword.getText().toString();
                    String email = uemail.getText().toString();
                    String address = uaddress.getText().toString();

                    UserHelperClass helperClass = new UserHelperClass(name,password,email,address);

                    reference.setValue(helperClass);


                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password);
                }
                Intent intent = new Intent(signup.this, search.class);
                startActivity(intent);
                Toast.makeText(signup.this,"Your account created ",Toast.LENGTH_SHORT ).show();
            }
        });

    }


    private void setupViews(){
        username = (EditText)findViewById(R.id.siname);
        upassword= (EditText)findViewById(R.id.siPassword);
        uemail= (EditText)findViewById(R.id.siemail);
        uaddress= (EditText)findViewById(R.id.siaddress);
        login= (Button) findViewById(R.id.buttonup);
    }
    private Boolean validate(){
        Boolean result = false;
        String name = username.getText().toString();
        String password = upassword.getText().toString();
        String email = uemail.getText().toString();
        String address = uaddress.getText().toString();

        if (name.isEmpty() ||  password.isEmpty() || email.isEmpty() || address.isEmpty() ){
            Toast.makeText(this,"Please enter all the details", Toast.LENGTH_SHORT);
        }else{
            result = true;
        }
        return result;
    }
}