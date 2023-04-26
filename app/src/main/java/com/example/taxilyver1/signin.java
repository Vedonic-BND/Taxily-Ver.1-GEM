package com.example.taxilyver1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signin extends AppCompatActivity {

    EditText mainemail, inpass;
    TextView forgotpass;
    Button sgnup;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);

        Button sgnup = (Button) findViewById(R.id.sgnup);
        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, signup.class);
                startActivity(intent);
                finish();
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mainemail = (EditText) findViewById(R.id.mainemail);
        inpass = (EditText) findViewById(R.id.inpass);
        forgotpass = (TextView) findViewById(R.id.forgotpass);

        mAuth = FirebaseAuth.getInstance();

    }

    public void sgninbtnButtonClicked (View v) {
        String email = mainemail.getText().toString().trim();
        String password = inpass.getText().toString().trim();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mainemail.setError("Please enter a Valid Email");
            mainemail.requestFocus();
        }
        if (password.length() < 6) {
            inpass.setError("Please enter a Valid Password");
            inpass.requestFocus();

        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(signin.this, "User Has Successfully Signed In", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(signin.this, "User Has Failed to Signed In", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent (signin.this, scanner.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void  txtForgotPassClicked(View v) {

    }

    public void sgnupbtnButtonClicked(View view) {
    }
}