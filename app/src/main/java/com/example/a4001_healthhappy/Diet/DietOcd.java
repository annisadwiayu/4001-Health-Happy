package com.example.a4001_healthhappy.Diet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a4001_healthhappy.R;

public class DietOcd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_ocd);
    }
    public void intentOCD(View view) {
        Intent intent = new Intent(DietOcd.this, DietOcd.class);
        startActivity(intent);
    }
}


