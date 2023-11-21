package com.example.h_wintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Intent backIntent = getIntent();
        ArrayList<Integer> mas =  backIntent.getIntegerArrayListExtra("mas");
        mas.add(2);
        Log.d("Mas", "2: " + mas);
        //Переход на 1 активити
        Button b1 = findViewById(R.id.btnReturnToA1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity1.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);

            }
        });
        //Переход на 3 активити
        Button b3 = findViewById(R.id.btnReturnToA3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);

            }
        });
        //Переход в начало
        Button b0 = findViewById(R.id.btnReturnToA0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);
            }
        });
    }
}
