package com.example.test1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;



import com.example.test1.adapter.MyViewPager2Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_FAVORITE = 1;
    private static final int FRAGMENT_SEARCH = 2;
    private static final int FRAGMENT_PROFILE = 3;
    private int mFragmentCurrent = FRAGMENT_HOME;
    DrawerLayout drawerLayout;
    MyViewPager2Adapter adapter = null;
    Toolbar toolBar;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    NavigationView navView;
    BottomNavigationView navBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDrawerLayout();
        createToolBar();
        createViewPager2();
        createTabLayout();
        createNavigationView();
        createBottomNavigationView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    private void createBottomNavigationView() {
        navBot = findViewById(R.id.navBot);
        navBot.setItemIconTintList(null);
        navBot.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.bottomHome) {
                    openHome();
                    navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                } else if (id == R.id.bottomFavorite) {
                    openFavorite();
                    navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                } else if (id == R.id.bottomSearch) {
                    openSearch();
                    navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                } else if (id == R.id.bottomProfile) {
                    openProfile();
                    navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                }
                return true;
            }
        });
    }

    private void createNavigationView() {
        navView = findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);
        navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
        navView.setItemIconTintList(null);
    }

    private void createTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabIconTint(null);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Home");
                    tab.setIcon(R.drawable.home);
                } else if (position == 1) {
                    tab.setText("Favorite");
                    tab.setIcon(R.drawable.favorite);
                } else if (position == 2) {
                    tab.setText("Search");
                    tab.setIcon(R.drawable.search);
                } else if (position == 3) {
                    tab.setText("Profile");
                    tab.setIcon(R.drawable.profile);
                }
            }
        }).attach();

    }

    private void createViewPager2() {
        viewPager2 = findViewById(R.id.viewPager);
        adapter = new MyViewPager2Adapter(this);
        viewPager2.setAdapter(adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mFragmentCurrent = FRAGMENT_HOME;
                        openHome();
                        navBot.getMenu().findItem(R.id.bottomHome).setChecked(true);
                        navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                        break;
                    case 1:
                        mFragmentCurrent = FRAGMENT_FAVORITE;
                        openFavorite();
                        navBot.getMenu().findItem(R.id.bottomFavorite).setChecked(true);
                        navView.getMenu().findItem(R.id.drawerFavorite).setChecked(true);
                        break;
                    case 2:
                        mFragmentCurrent = FRAGMENT_SEARCH;
                        openSearch();
                        navBot.getMenu().findItem(R.id.bottomSearch).setChecked(true);
                        navView.getMenu().findItem(R.id.drawerSearch).setChecked(true);
                        break;
                    case 3:
                        mFragmentCurrent = FRAGMENT_PROFILE;
                        openProfile();
                        navBot.getMenu().findItem(R.id.bottomProfile).setChecked(true);
                        navView.getMenu().findItem(R.id.drawerProfile).setChecked(true);
                        break;
                    default:
                        mFragmentCurrent = FRAGMENT_HOME;
                        openHome();
                        navBot.getMenu().findItem(R.id.bottomHome).setChecked(true);
                        navView.getMenu().findItem(R.id.drawerHome).setChecked(true);
                        break;
                }
            }
        });

    }


    private void openHome() {
        if (mFragmentCurrent != FRAGMENT_HOME) {
            viewPager2.setCurrentItem(0);
            mFragmentCurrent = FRAGMENT_HOME;
        }
    }

    private void openFavorite() {
        if (mFragmentCurrent != FRAGMENT_FAVORITE) {
            viewPager2.setCurrentItem(1);
            mFragmentCurrent = FRAGMENT_FAVORITE;
        }
    }

    private void openSearch() {
        if (mFragmentCurrent != FRAGMENT_SEARCH) {
            viewPager2.setCurrentItem(2);
            mFragmentCurrent = FRAGMENT_SEARCH;
        }
    }

    private void openProfile() {
        if (mFragmentCurrent != FRAGMENT_PROFILE) {
            viewPager2.setCurrentItem(3);
            mFragmentCurrent = FRAGMENT_PROFILE;
        }
    }


    private void createToolBar() {
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
    }

    private void createDrawerLayout() {
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.drawerHome) {
            openHome();
        } else if (id == R.id.drawerFavorite) {
            openFavorite();
        } else if (id == R.id.drawerSearch) {
            openSearch();
        } else if (id == R.id.drawerProfile) {
            openProfile();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }
}