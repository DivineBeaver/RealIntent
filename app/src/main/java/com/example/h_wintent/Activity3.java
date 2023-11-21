package com.example.h_wintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Intent backIntent = getIntent();
        ArrayList<Integer> mas =  backIntent.getIntegerArrayListExtra("mas");
        mas.add(3);
        Log.d("Mas", "3: " + mas);
        //Переход на 2 активити
        Button b2 = findViewById(R.id.btnReturnToA2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, Activity2.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);

            }
        });
        //Переход на 1 активити
        Button b1 = findViewById(R.id.btnReturnToA1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, Activity1.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);

            }
        });
        //Переход в начало
        Button b0 = findViewById(R.id.btnReturnToA0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, MainActivity.class);
                intent.putIntegerArrayListExtra("mas",mas);
                startActivity(intent);
            }
        });
    }
}
