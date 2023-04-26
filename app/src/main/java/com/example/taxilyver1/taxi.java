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
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.Result;

public class taxi extends AppCompatActivity {

    TextView qrtext;
    private FirebaseDatabase db;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_taxi);

        //Retrieve Data Info From Scanned QR Code
        qrtext = findViewById(R.id.qrtext);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("Taxi Details");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String info = snapshot.getValue(String.class);
                qrtext.setText(info);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Taxi to Profile
        TextView profbtn = (TextView) findViewById(R.id.profbtn);
        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taxi.this, profile.class);
                startActivity(intent);
                finish();
            }
        });

        //Taxi to Scanner
        ImageView scanbtn = (ImageView) findViewById(R.id.scanbtn);
        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taxi.this, scanner.class);
                startActivity(intent);
                finish();
            }
        });

        //Taxi to Chat
        TextView chatbtn = (TextView) findViewById(R.id.chatbtn);
        chatbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taxi.this, chat.class);
                startActivity(intent);
                finish();
            }
        });

        //Taxi to Map
        TextView mapbtn = (TextView) findViewById(R.id.mapbtn);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taxi.this, map.class);
                startActivity(intent);
                finish();
            }
        });
    }
}