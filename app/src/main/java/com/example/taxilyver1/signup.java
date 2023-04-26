package com.example.taxilyver1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class signup extends AppCompatActivity {

    EditText editname, editemail, editpass, editnum;
    Button sgnin, sgnupbtn;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);

        Button sgnin = (Button) findViewById(R.id.sgnin);
        sgnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, signin.class);
                startActivity(intent);
                finish();
            }
        });

        editname = (EditText) findViewById(R.id.editname);
        editemail = (EditText) findViewById(R.id.editemail);
        editpass = (EditText) findViewById(R.id.editpass);
        editnum = (EditText) findViewById(R.id.editnum);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
    }

    public void sgnupbtnButtonClicked (View v) {
        String newname = editname.getText().toString().trim();
        String newemail = editemail.getText().toString().trim();
        String newpass = editpass.getText().toString().trim();
        String newnum = editnum.getText().toString().trim();

        if (newname.isEmpty()) {
            editname.setError("Please enter Name");
            editname.requestFocus();
        }
        if (newemail.isEmpty()) {
            editemail.setError("Please enter Valid Email");
            editemail.requestFocus();
        }
        if (newpass.isEmpty() || newpass.length() < 6) {
            editpass.setError("Please enter Password");
            editpass.requestFocus();
        }
        if (newnum.isEmpty() || newnum.length() < 10) {
            editnum.setError("Please enter Contact Number");
            editnum.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        //Save Data to Firebase
        mAuth.createUserWithEmailAndPassword(newemail, newpass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(newname, newemail, newpass, newnum);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(signup.this, "User Signed Up Successfully", Toast.LENGTH_LONG).show();
                                            } else {
                                                Toast.makeText(signup.this, "User Failed to Sign Up", Toast.LENGTH_LONG).show();
                                            }
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                        } else {
                            Toast.makeText(signup.this, "User Already Exists", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }

                        Intent intent = new Intent (signup.this, signin.class);
                        startActivity(intent);
                        finish();
                    }
                });

    }
    public void sgninbtnButtonClicked(View view) {
    }
}