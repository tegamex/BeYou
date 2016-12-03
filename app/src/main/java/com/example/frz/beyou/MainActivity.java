package com.example.frz.beyou;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

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
                        .replace(R.id.fragmento,new HomeFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_singup:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_notification:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new NotificationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_promotion:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new PromotionFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new FeaturesFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new UserProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_reserva:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new ReservaFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_publish:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new PublishFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_calification:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new ServiceCalification()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_diagnostic:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new DiagnosticFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_LogOut:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new LoadFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_message:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new MessageFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_Reserva:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new RequestReservationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_sube_imagen:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new SelectImageFragment()).addToBackStack(null).commit();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
