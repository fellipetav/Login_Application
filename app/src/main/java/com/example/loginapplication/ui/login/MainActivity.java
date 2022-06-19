package com.example.loginapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText formEmail;
    EditText formPassword;
    // TextView register;
    Button loginBtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        formEmail = (EditText) findViewById(R.id.username);
        formPassword = (EditText) findViewById(R.id.password);
        Button = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent loginIntent = new Intent(this, LoginActivity.class);
                //startActivity(loginIntent);
                String email = formEmail.getText().toString().trim();
                String password = formPassword.getText().toString().trim();
                String username = email.substring(0, email.indexOf("@"));
                if(db.isUserRegistered(email, password)){
                    /*We can create an Intent and go to another activity or screen,
                    else show a Toast Message*/
                    Intent moveToWelcomePage = new Intent(this, WelcomeActivity.class);
                    moveToWelcomePage.putExtra("username", username);
                    startActivity(moveToWelcomePage)
                    Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "User does not existis", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}