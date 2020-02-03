package com.deathalurer.codmobileguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.deathalurer.codmobileguide.Fragments.About;
import com.deathalurer.codmobileguide.Fragments.AmmoFragment;
import com.deathalurer.codmobileguide.Fragments.AttachmentFragment;
import com.deathalurer.codmobileguide.Fragments.ConsumableFragment;
import com.deathalurer.codmobileguide.Fragments.DialogFragment;
import com.deathalurer.codmobileguide.Fragments.Donate;
import com.deathalurer.codmobileguide.Fragments.MapFragment;
import com.deathalurer.codmobileguide.Fragments.Report;
import com.deathalurer.codmobileguide.Fragments.ThrowableFragment;
import com.deathalurer.codmobileguide.Fragments.WeaponFragment;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new WeaponFragment()).commit();
        navigationView.setCheckedItem(R.id.weapon);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.weapon :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new WeaponFragment()).commit();
                        break;
                    case R.id.throwable :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ThrowableFragment()).commit();
                        break;
                    case R.id.consume :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConsumableFragment()).commit();
                        break;
                    case R.id.maps :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MapFragment()).commit();
                        break;
                    case R.id.attach :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AttachmentFragment()).commit();
                        break;
                    case R.id.report :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Report()).commit();
                        break;
                    case R.id.about :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new About()).commit();
                        break;
                    case R.id.ammo :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AmmoFragment()).commit();
                        break;
                    case R.id.skills:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new SkillModes()).commit();
                        break;
                    case R.id.share :
                        String shareBody = "https://youtu.be/5UAWoCUQtKM";
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "sharing intent"));
                        break;
                }
                navigationView.setCheckedItem(menuItem.getItemId());
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_menu_main, menu);
        return true;
    }


}
