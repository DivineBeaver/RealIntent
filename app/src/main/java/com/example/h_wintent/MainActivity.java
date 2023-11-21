package com.example.h_wintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 1;
    protected ArrayList<Integer> mas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        Bundle arg = getIntent().getExtras();
        if(arg!=null){
            ArrayList<Integer> m = intent.getIntegerArrayListExtra("mas");

            final Handler handler = new Handler();
            int delayMillis = 2000; // Задержка в миллисекундах
            for (final Integer a : m) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "" + a, Toast.LENGTH_SHORT).show();
                    }
                }, delayMillis);
                delayMillis += 2000; // Увеличиваем задержку для следующего элемента

            }
        }
        Button b0 = findViewById(R.id.ButtonStart);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(MainActivity.this, Activity1.class);
                intent0.putExtra("mas",mas);
                startActivity(intent0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            ArrayList<Integer> mas = data.getIntegerArrayListExtra("mas");
            Log.d("Mas", "0: " + mas);

            final Handler handler = new Handler();
            int delayMillis = 2000; // Задержка в миллисекундах
            for (final Integer a : mas) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "" + a, Toast.LENGTH_SHORT).show();
                    }
                }, delayMillis);
                delayMillis += 2000; // Увеличиваем задержку для следующего элемента
            }
        }

    }
}