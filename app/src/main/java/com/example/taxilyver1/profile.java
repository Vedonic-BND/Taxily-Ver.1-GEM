package com.example.taxilyver1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profile extends AppCompatActivity {

    private TextView name, email, pass, num;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private String memail;
    private static final String USERS = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        //Retrieve Data from Firebase
        Intent intent = getIntent();
        memail = intent.getStringExtra("mainemail");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("UserUID", userRef.getKey());

        name = (TextView) findViewById(R.id.txtname);
        email = (TextView) findViewById(R.id.txtemail);
        pass = (TextView) findViewById(R.id.txtemail);
        num = (TextView) findViewById(R.id.txtnum);

        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(USERS);

        userRef.addValueEventListener(new ValueEventListener() {
            String inname, inemail, inpass, innum;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot keyId : dataSnapshot.getChildren()) {
                    if (keyId.child("newemail").getValue().equals(memail)) {
                        inname = keyId.child("newname").getValue(String.class);
                        inemail = keyId.child("newemail").getValue(String.class);
                        inpass = keyId.child("newpass").getValue(String.class);
                        innum = keyId.child("newnum").getValue(String.class);
                        break;
                    }
                }
                name.setText(inname);
                email.setText(inemail);
                pass.setText(inpass);
                num.setText(innum);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //Profile to Taxi
        TextView taxibtn = (TextView) findViewById(R.id.taxibtn);
        taxibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, taxi.class);
                startActivity(intent);
                finish();
            }
        });

        //Profile to Scanner
        ImageView scanbtn = (ImageView) findViewById(R.id.scanbtn);
        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, scanner.class);
                startActivity(intent);
                finish();
            }
        });

        //Profile to Chat
        TextView chatbtn = (TextView) findViewById(R.id.chatbtn);
        chatbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, chat.class);
                startActivity(intent);
                finish();
            }
        });

        //Profile to Map
        TextView mapbtn = (TextView) findViewById(R.id.mapbtn);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, map.class);
                startActivity(intent);
                finish();
            }
        });


    }
}