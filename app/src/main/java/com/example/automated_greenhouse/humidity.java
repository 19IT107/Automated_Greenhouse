package com.example.automated_greenhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class humidity extends AppCompatActivity {
    Button RD;
    TextView H;
    DatabaseReference dref;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);

        RD = (Button)findViewById(R.id.retrieve_data_H);
        H = (TextView) findViewById(R.id.get_hum);
        RD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref = FirebaseDatabase.getInstance().getReference().child("Data");
                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String s = snapshot.child("Humidity").getValue().toString();

                        H.setText(s);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

}