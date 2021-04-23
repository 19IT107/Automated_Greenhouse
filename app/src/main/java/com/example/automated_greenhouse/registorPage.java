package com.example.automated_greenhouse;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class registorPage extends AppCompatActivity {
    Button login,registor_button;
    EditText registor_fullname,registor_emailid,registor_password,registor_conformpassword;
    CheckBox show2;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor_page);

        login = findViewById(R.id.log_in);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registorPage.this,MainActivity.class));
            }
        });

        registor_fullname = findViewById(R.id.full_name);
        registor_emailid = findViewById(R.id.email_id);
        registor_password = findViewById(R.id.password);
        registor_conformpassword = findViewById(R.id.conform_password);
        registor_button= findViewById(R.id.register);
        fAuth = FirebaseAuth.getInstance();

        registor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = registor_fullname.getText().toString();
                String emailid = registor_emailid.getText().toString();
                String password = registor_password.getText().toString();
                String conformpassword =registor_conformpassword.getText().toString();

                if(fullname.isEmpty())
                {
                    registor_fullname.setError("full name is required");
                    return;
                }

                if(emailid.isEmpty())
                {
                    registor_emailid.setError("Email ID is required");
                    return;
                }

                if(password.isEmpty())
                {
                    registor_password.setError("password is required");
                    return;
                }

                if(conformpassword.isEmpty())
                {
                    registor_conformpassword.setError("conform password is required");
                    return;
                }
                if((password.length())<8)
                {
                    registor_password.setError("password length must be greater than 8");
                    return;
                }
                if((!emailid.contains("@")) || (!emailid.contains(".com")))
                {
                    registor_emailid.setError("Enter correct Email (eg. abc@gamil.com)");
                    return;
                }

                if(!password.equals(conformpassword))
                {
                    registor_conformpassword.setError("conform Password does not matches password");
                    return;
                }

                Toast.makeText(registorPage.this , "data validated" , Toast.LENGTH_SHORT).show();
                fAuth.createUserWithEmailAndPassword(emailid,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(registorPage.this,navigation.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(registorPage.this , e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        show2 = findViewById(R.id.show2);

        show2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    registor_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    registor_conformpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    registor_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    registor_conformpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

    }
}