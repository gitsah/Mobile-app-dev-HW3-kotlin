package com.example.sahand.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        String username = getIntent().getStringExtra("USER");
        welcomeMessage = findViewById(R.id.textView);
        welcomeMessage.setText(String.format("Thanks for Signing Up %s!", username));

        if(savedInstanceState != null) {
            welcomeMessage.setText(savedInstanceState.getString("TEXT"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("TEXT", welcomeMessage.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    public void toMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
