package com.tesis.marco_aldany;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class Home_M_A extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f=null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    f = new NotasApp();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_id,f).commit();
                    return true;
                case R.id.navigation_dashboard:
                    f = new Reservas_App();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_id,f).commit();
                    return true;
                case R.id.navigation_notifications:
                    f = new Ubicaion_App();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_id,f).commit();
                    return true;
            }
            if (f!= null){
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_id,f).commit();
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__m_);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_id,new NotasApp()).commit();
    }

}
