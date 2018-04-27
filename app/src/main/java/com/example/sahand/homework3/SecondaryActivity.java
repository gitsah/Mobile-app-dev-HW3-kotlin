package com.example.sahand.homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.sahand.homework3.R;

public class SecondaryActivity extends AppCompatActivity {
    private TextView nameAndAge;
    private TextView occupation;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        nameAndAge = findViewById(R.id.name_and_age_display);
        nameAndAge.setText(getIntent().getStringExtra("NAMEANDAGE"));
        occupation = findViewById(R.id.occupation_display);
        occupation.setText(getIntent().getStringExtra("OCCUPATION"));
        description = findViewById(R.id.description_display);
        description.setText(getIntent().getStringExtra("DESCRIPTION"));


        if(savedInstanceState != null) {
            nameAndAge.setText(savedInstanceState.getString("NAMEANDAGE"));
            occupation.setText(savedInstanceState.getString("OCCUPATION"));
            description.setText(savedInstanceState.getString("DESCRIPTION"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("NAMEANDAGE", nameAndAge.getText().toString());
        savedInstanceState.putString("OCCUPATION", occupation.getText().toString());
        savedInstanceState.putString("DESCRIPTION", description.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    public void toMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
