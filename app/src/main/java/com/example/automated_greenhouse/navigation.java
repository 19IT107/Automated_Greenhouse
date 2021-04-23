package com.example.automated_greenhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class navigation extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model( 1,R.drawable.home));
       // bottomNavigation.add(new MeowBottomNavigation.Model( 2,R.drawable.weather));
        bottomNavigation.add(new MeowBottomNavigation.Model( 2,R.drawable.info));



        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                // Activity ac = null;
                switch (item.getId()){
                    case 1:
                        fragment = new Home();
                        break;

                  //  case 2:
                    //    fragment = new WeatherFragment();
                    //    break;
                    case 2:
                        fragment = new Info();
                }
                loadFragment(fragment);
            }
        });

        bottomNavigation.show(1,true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//             Toast.makeText(getApplicationContext()
//                     ,  "you clicked"  + item.getId()
//                     ,Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//               Toast.makeText(getApplicationContext()
//               ,"you reselect" + item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
//        if(findViewById(R.id.homeActivity)!=null)
//        {
//            if(savedInstanceState!=null)
//            {
//                return;
//            }
//            FragmentManager fm =getSupportFragmentManager();
//            fm.beginTransaction().add(R.id.homeActivity, new HomeFragment(),null).commit();
//        }
////        Button temperature;
//        temperature = findViewById(R.id.temperature);
//        temperature.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent CategoryIntent = new Intent(MainActivity.this,temperature.class);
//                startActivity(CategoryIntent);
//                //finish();
//            }
//        });
//        HomeFragment hf = new HomeFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.temperature, hf).commit();
    }
    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commitAllowingStateLoss();
    }

}