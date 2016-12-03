package com.example.frz.beyou;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.frz.beyou.BeYou.FragmentFeeds;
import com.example.frz.beyou.widget.refresh.XMultiColumnListView;

import java.util.List;


public class MuralFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,NavigationView.OnNavigationItemSelectedListener {
    SwipeRefreshLayout swipe;
    DrawerLayout drawer;
    XMultiColumnListView listView;
    int[] lista={R.drawable.arrow_down,R.drawable.arrow_up,R.drawable.border,R.drawable.ic_meepo,R.drawable.ic_meepo2};
    Fragment fg;
    Fragment fg2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mural, container,false);
        Toolbar toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_settings:
                        getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit).replace(R.id.fragment,new ProfileFragment())
                                //.addToBackStack(null)
                                .commit();
                        return true;
                }
                return false;
            }
        });
        drawer = (DrawerLayout) v.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //fg=(Fragment) getChildFragmentManager().getFragments().get(0);

        //fg2=(Fragment) v.findViewById(R.id.fragmento);
        NavigationView navigationView = (NavigationView) v.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmento,new FragmentFeeds()).commit();

        return v;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                swipe.setRefreshing(false);
            }
        }, 3000);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new FragmentFeeds()).commit();
                break;
            case R.id.nav_singup:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_notification:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new NotificationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_promotion:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new PromotionFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_profile:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new FeaturesFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_profile:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new UserProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_reserva:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new ReservaFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_publish:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new PublishFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_calification:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new ServiceCalification()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_diagnostic:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new DiagnosticFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_LogOut:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new LoadFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_message:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new MessageFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_Reserva:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new RequestReservationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_user_sube_imagen:
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmento,new SelectImageFragment()).addToBackStack(null).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onPause() {
        super.onPause();
        //fg.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        //fg.onResume();
    }

    public class Adapter<T> extends ArrayAdapter<T> {
        public Adapter(Context context, List<T> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View listItemView = convertView;
            if (null == convertView) {
                listItemView = inflater.inflate(
                        R.layout.list_element,
                        parent,
                        false);
            }

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.imagen);
            imageView.setImageResource((Integer) getItem(position));
            return listItemView;
        }
    }
}
