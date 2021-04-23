package com.example.automated_greenhouse;

import androidx.annotation.NonNull;
import   androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button registor,signin;
    CheckBox show;
    EditText loginpassword,loginemailid;
    FirebaseAuth fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fa = FirebaseAuth.getInstance();
        loginemailid = findViewById(R.id.login_emailid);
        loginpassword = findViewById(R.id.login_password);
        show = findViewById(R.id.show);
        signin = findViewById(R.id.sign_in);

        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    loginpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    loginpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });




        registor = findViewById(R.id.sign_up);

        registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,registorPage.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if( loginemailid.getText().toString().isEmpty() ){
                   loginemailid.setError("Email_id is missing");
                   return;
               }

                if( loginpassword.getText().toString().isEmpty() ){
                    loginpassword.setError("password is missing");
                    return;
                }
                fa.signInWithEmailAndPassword(loginemailid.getText().toString(),loginpassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),navigation.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),navigation.class));
            finish();
        }
    }
}