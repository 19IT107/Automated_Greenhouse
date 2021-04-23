package com.example.automated_greenhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class temperature extends AppCompatActivity {
    Button RD;
    TextView T;
    DatabaseReference dref;
    String s;
    EditText MT,mT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        RD = (Button)findViewById(R.id.retrieve_data_T);
        T = (TextView) findViewById(R.id.get_temp);

       RD.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dref = FirebaseDatabase.getInstance().getReference().child("Data");
               dref.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot snapshot) {
                       String s = snapshot.child("Temperature").getValue().toString();

                       T.setText(s);






                       //if(T_int>MT_int)
                       //{
//                           String M_message = "Temperature limit has been reached";
//
//                           NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(
//                                   temperature.this)
//                                   .setSmallIcon(R.drawable.notifications)
//                                   .setContentTitle("New Notification")
//                                   .setContentText(M_message)
//                                   .setAutoCancel(true);
//                           Intent i = new Intent(temperature.this, notification.class);
//                           i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
//                           i.putExtra("Message" , M_message);
//
//                           PendingIntent PI = PendingIntent.getActivity(temperature.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
//                           mbuilder.setContentIntent(PI);
//
//                           NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//                           notificationManager.notify(0,mbuilder.build());

                       //}
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                   }
               });
           }
       });

    }
}