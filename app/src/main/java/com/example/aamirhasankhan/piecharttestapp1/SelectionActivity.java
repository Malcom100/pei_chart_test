package com.example.aamirhasankhan.piecharttestapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {
    Button btnTab,btnGest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        btnTab = (Button) findViewById(R.id.TABS);
        btnGest= (Button) findViewById(R.id.GESTURES);

        btnTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SelectionActivity.this,SampleTabActivity.class));
            }
        });

        btnGest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectionActivity.this,GestureActivity.class));
            }
        });
    }
}
