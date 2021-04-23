package com.example.automated_greenhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class soil_moisture extends AppCompatActivity {

    Button RD;
    TextView SM;
    DatabaseReference dref;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_moisture);

        RD = (Button)findViewById(R.id.retrieve_data_SM);
        SM = (TextView) findViewById(R.id.get_SM);
        RD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref = FirebaseDatabase.getInstance().getReference().child("Data");
                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String s = snapshot.child("Soil-Moisture").getValue().toString();
                        SM.setText(s);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}