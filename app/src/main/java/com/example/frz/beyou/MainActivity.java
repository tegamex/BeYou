package com.example.frz.beyou;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.frz.beyou.HomeFragment;
import com.example.frz.beyou.NotificationFragment;
import com.example.frz.beyou.ProfileFragment;
import com.example.frz.beyou.PromotionFragment;
import com.example.frz.beyou.RegisterFragment;
import com.example.frz.beyou.ReservaFragment;
import com.example.frz.beyou.UserProfileFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static private MainActivity instance;
    public static MainActivity getInstance(){
        return instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        instance=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState==null)
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.principal, new HomeFragment()).commit();*/
    }

    @Override
    public void onBackPressed() {
        /*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        super.onBackPressed();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new HomeFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_singup:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_notification:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new NotificationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_promotion:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new PromotionFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new ProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new UserProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_reserva:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.principal,new ReservaFragment()).addToBackStack(null).commit();
                break;


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
