package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnlog,btnsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsing=findViewById(R.id.btnsing);
        btnlog=findViewById(R.id.btnlog);
        btnlog.setOnClickListener(this);
        btnsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlog:
                Intent intent=new Intent(MainActivity.this,loginpage.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnsing:
                Intent i=new Intent(MainActivity.this,singup.class);
                startActivity(i);
                finish();
                break;
        }
    }
}