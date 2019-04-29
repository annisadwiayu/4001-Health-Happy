package com.example.a4001_healthhappy.Program;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a4001_healthhappy.Diet.DietKeto;
import com.example.a4001_healthhappy.Diet.DietMayo;
import com.example.a4001_healthhappy.Diet.DietOcd;
import com.example.a4001_healthhappy.R;


public class ListDiet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_diet);

        ListDiet.this.setTitle("List Diet");
    }

    public void intentMenu (View view) {
        switch (view.getId()){
            case R.id.dietketo:
                Intent intent1 = new Intent(ListDiet.this, DietKeto.class);
                startActivity(intent1);
                break;
            case R.id.dietmayo:
                Intent intent2 = new Intent(ListDiet.this, DietMayo.class);
                startActivity(intent2);
                break;
            case R.id.dietocd:
                Intent intent3 = new Intent(ListDiet.this, DietOcd.class);
                startActivity(intent3);
                break;
        }
    }

}