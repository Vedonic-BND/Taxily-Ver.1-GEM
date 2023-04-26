package com.example.taxilyver1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chat);

        //Chat to Profile
        TextView profbtn = (TextView) findViewById(R.id.profbtn);
        profbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chat.this, profile.class);
                startActivity(intent);
                finish();
            }
        });

        //Chat to Taxi
        TextView taxibtn = (TextView) findViewById(R.id.taxibtn);
        taxibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chat.this, taxi.class);
                startActivity(intent);
                finish();
            }
        });

        //Chat to Scanner
        ImageView scanbtn = (ImageView) findViewById(R.id.scanbtn);
        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chat.this, scanner.class);
                startActivity(intent);
                finish();
            }
        });

        //Chat to Map
        TextView mapbtn = (TextView) findViewById(R.id.mapbtn);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chat.this , map.class);
                startActivity(intent);
                finish();
            }
        });
    }
}