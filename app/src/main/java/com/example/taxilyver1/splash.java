package com.example.taxilyver1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ThemedSpinnerAdapter;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        LottieAnimationView anima = findViewById(R.id.anima);
        anima.animate().translationX(-1000).setDuration(1000).setStartDelay(2500);


        TextView splashmess = findViewById(R.id.splashmess);
        splashmess.animate().translationX(1000).setDuration(1000).setStartDelay(2500);

        Thread thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(4000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent (splash.this, signup.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
}