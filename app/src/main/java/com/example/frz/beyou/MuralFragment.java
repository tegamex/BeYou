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

import com.example.frz.beyou.widget.refresh.XMultiColumnListView;

import java.util.List;


public class MuralFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,NavigationView.OnNavigationItemSelectedListener {
    SwipeRefreshLayout swipe;
    DrawerLayout drawer;
    XMultiColumnListView listView;
    int[] lista={R.drawable.arrow_down,R.drawable.arrow_up,R.drawable.border,R.drawable.ic_meepo,R.drawable.ic_meepo2};
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
                                .addToBackStack(null).commit();
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

        NavigationView navigationView = (NavigationView) v.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
            case R.id.nav_notification:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit)
                        .replace(R.id.fragment,new PromotionFragment()).addToBackStack(null).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
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
