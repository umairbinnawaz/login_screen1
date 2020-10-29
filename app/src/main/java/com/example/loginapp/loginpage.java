package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class loginpage extends AppCompatActivity implements View.OnClickListener {
    EditText edmail1,edpasd2;
    Button btnlog1;
    SharedPreferences sp;
    ImageView show_pass_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        btnlog1=findViewById(R.id.btnlog1);
        edmail1=findViewById(R.id.edmail1);
        show_pass_btn1=findViewById(R.id.show_pass_btn1);

        edpasd2=findViewById(R.id.edpasd2);
        btnlog1.setOnClickListener(this);
        show_pass_btn1.setOnClickListener(this);


        sp=getSharedPreferences("data",MODE_PRIVATE);
        String e=sp.getString("Email","");
        String p=sp.getString("Password","");
        Log.e("Email===>",e);
        Log.e("Password==>",p);
        edmail1.setText(e);
        edpasd2.setText(p);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlog1:

                Intent intent=new Intent(loginpage.this,finalpage.class);
                startActivity(intent);
                finish();
                break;
            case R.id.show_pass_btn1:
                if (edpasd2.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    show_pass_btn1.setImageResource(R.drawable.eye);
                    //Show Password
                    edpasd2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
//
                    show_pass_btn1.setImageResource(R.drawable.uneye);
                    //Hide Password
                    edpasd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                break;
        }
    }
}