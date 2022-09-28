package com.example.yellowbook.contacts;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.yellowbook.MainActivity;
import com.example.yellowbook.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class shops extends AppCompatActivity  {


    RecyclerView recyclerView;

    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();
    ArrayList<String> phone = new ArrayList<>();



    ImageView menu, back;

    static final float END_SCALE = 0.7f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_contacts);

        Adapter adapter;


        recyclerView = findViewById(R.id.recyclerview);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shops.this, MainActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            JSONArray array = obj.getJSONArray("general");
            for (int i = 0; i < array.length(); i++) {
                JSONObject details = array.getJSONObject(i);
                name.add(details.getString("name"));
                address.add(details.getString("address"));
                phone.add(details.getString("phone"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter customAdapter = new CustomAdapter(name, address, phone, shops.this);
        recyclerView.setAdapter(customAdapter);


    }

    private String loadJSONfromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("contacts.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
