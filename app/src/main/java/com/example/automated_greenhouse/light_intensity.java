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

public class light_intensity extends AppCompatActivity {
    Button RD;
    TextView LI;
    DatabaseReference dref;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_intensity);
        RD = (Button)findViewById(R.id.retrieve_data_LI);
        LI = (TextView) findViewById(R.id.get_LI);
        RD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref = FirebaseDatabase.getInstance().getReference().child("Data").child("Water-Level");
                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String s = snapshot.getValue().toString();
                        LI.setText(s);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}