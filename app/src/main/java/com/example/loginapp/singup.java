package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class singup extends AppCompatActivity implements View.OnClickListener {
    EditText edname,edmail,edpasd,edpasdc;
    Button btnsing1;
    SharedPreferences dsp;
    ImageView show_pass_btn,show_pass_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        btnsing1=findViewById(R.id.btnsing1);
        edname=findViewById(R.id.edname);
        edmail=findViewById(R.id.edmail);
        edpasd=findViewById(R.id.edpasd);
        edpasdc=findViewById(R.id.edpasdc);
        show_pass_btn=findViewById(R.id.show_pass_btn);
        show_pass_btn2=findViewById(R.id.show_pass_btn2);
        btnsing1.setOnClickListener(this);
        show_pass_btn2.setOnClickListener(this);

        show_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowHidePass(v);
            }
        });

    }
    public void ShowHidePass(View view) {


        if (view.getId() == R.id.show_pass_btn) {
            if (edpasd.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                show_pass_btn.setImageResource(R.drawable.eye);
                //Show Password
                edpasd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
//
                show_pass_btn.setImageResource(R.drawable.uneye);
                //Hide Password
                edpasd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnsing1:
                dsp=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor ed1=dsp.edit();
                ed1.putString("Email",edmail.getText().toString());
                ed1.putString("Password",edpasd.getText().toString());
                ed1.apply();
                Intent intent=new Intent(singup.this,loginpage.class);
                startActivity(intent);
                finish();
                break;

            case R.id.show_pass_btn2:
                    if (edpasdc.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                        show_pass_btn.setImageResource(R.drawable.eye);
                        //Show Password
                        edpasdc.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
//
                        show_pass_btn.setImageResource(R.drawable.uneye);
                        //Hide Password
                        edpasdc.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }

                break;

        }
    }
}