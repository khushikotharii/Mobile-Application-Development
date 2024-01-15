package com.example.brainbit;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText ed3,ed4;
    Button btn2;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView tv4;

    @Override
    public void onStart() {
        super.onStart();
        // if user logged in already, homepage is opened.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent welcome = new Intent(Register.this,homepage.class);
            startActivity(welcome);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        tv4 = findViewById(R.id.lg);
        ed3 = findViewById(R.id.ed3);
        ed4= findViewById(R.id.ed4);
        btn2 = findViewById(R.id.register);
        progressBar = findViewById(R.id.progressBar);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(Register.this,MainActivity.class);
                startActivity(log);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(ed3.getText());
                password = String.valueOf(ed4.getText());

                // Define regex patterns for email and password validation
                String emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

                // Create Pattern and Matcher objects for validation
                Pattern emailMatcher = Pattern.compile(emailPattern);
                Pattern passwordMatcher = Pattern.compile(passwordPattern);

                // Reset errors on EditText fields
                ed3.setError(null);
                ed4.setError(null);

                if (TextUtils.isEmpty(email)) {
                    ed3.setError("Enter Email");
                } else if (!emailMatcher.matcher(email).matches()) {
                    ed3.setError("Invalid Email Format");
                }

                if (TextUtils.isEmpty(password)) {
                    ed4.setError("Enter Password");
                } else if (!passwordMatcher.matcher(password).matches()) {
                    ed4.setError("Password must contain at least 8 characters, including at least one uppercase letter, one lowercase letter, and one digit");
                }

                if (emailMatcher.matcher(email).matches() && passwordMatcher.matcher(password).matches()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "Account created!", Toast.LENGTH_SHORT).show();
                                        Intent log = new Intent(Register.this, MainActivity.class);
                                        startActivity(log);
                                        finish();
                                    } else {
                                        // If registration fails, display a message to the user.
                                        Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}