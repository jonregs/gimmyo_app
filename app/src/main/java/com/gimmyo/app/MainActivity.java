package com.gimmyo.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gimmyo.app.bidboard.BidBoardHome;

/**
 * Created by Jon on 9/29/2017.
 */

public class MainActivity extends AppCompatActivity {

    String TAG = "BidBoard";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BidBoardHome.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
