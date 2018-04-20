package com.example.sahand.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //called when Cat button is pressed
    public void showHi(View view){
        TextView textView = findViewById(R.id.hi_text);
        textView.setVisibility(View.VISIBLE);
    }
}