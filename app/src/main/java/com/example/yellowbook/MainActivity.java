package com.example.yellowbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yellowbook.contacts.education;
import com.example.yellowbook.contacts.hospital;
import com.example.yellowbook.contacts.shops;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void close(View view) {
        System.exit(0);
    }


    public void education(View view) {
        Intent intent=new Intent(MainActivity.this,education.class);
        startActivity(intent);
    }

    public void hospital(View view) {
        Intent intent=new Intent(MainActivity.this, hospital.class);
        startActivity(intent);
    }

    public void shops(View view) {
        Intent intent=new Intent(MainActivity.this, shops.class);
        startActivity(intent);
    }
}