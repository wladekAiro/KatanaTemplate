package com.example.wladek.katanatemplate;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.wladek.katanatemplate.custom.CustomActivity;
import com.example.wladek.katanatemplate.models.Data;
import com.example.wladek.katanatemplate.ui.CategoryList;
import com.example.wladek.katanatemplate.ui.LeftNavAdapter;
import com.example.wladek.katanatemplate.ui.RecipeList;

import java.util.ArrayList;

public class MainActivity extends CustomActivity {
    private LeftNavAdapter adapter;
    private DrawerLayout drawerLayout;
    private View drawerLeft;
    private ActionBarDrawerToggle drawerToggle;

    /* renamed from: com.food.MainActivity.1 */
    class AnonymousClass1 extends ActionBarDrawerToggle {
        AnonymousClass1(Activity $anonymous0, DrawerLayout $anonymous1, int $anonymous2, int $anonymous3, int $anonymous4) {
            super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
        }

        public void onDrawerClosed(View view) {
            MainActivity.this.setActionBarTitle();
        }

        public void onDrawerOpened(View drawerView) {
            MainActivity.this.getActionBar().setTitle("Menu");
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupContainer();
        setupDrawer();
    }

    private void setupDrawer() {
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.drawerLayout.setDrawerShadow((int) R.drawable.drawer_shadow, (int) GravityCompat.START);
        this.drawerToggle = new AnonymousClass1(this, this.drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
        this.drawerLayout.setDrawerListener(this.drawerToggle);
        this.drawerLayout.closeDrawers();
        setupLeftNavDrawer();
    }

    private void setupLeftNavDrawer() {
        this.drawerLeft = findViewById(R.id.left);
        ListView leeftList = (ListView) findViewById(R.id.left_drawer);
        this.adapter = new LeftNavAdapter(this, getDummyLeftNavItems());
        leeftList.setAdapter(this.adapter);
        leeftList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int pos, long arg3) {
                MainActivity.this.drawerLayout.closeDrawers();
                MainActivity.this.launchFragment(pos);
            }
        });
        this.drawerLayout.openDrawer(this.drawerLeft);
        setTouchNClick(R.id.logout);
    }

    private ArrayList<Data> getDummyLeftNavItems() {
        ArrayList<Data> al = new ArrayList();
        al.add(new Data("Home", (int) R.drawable.ic_nav1, (int) R.drawable.ic_nav1_sel));
        al.add(new Data("Compose", (int) R.drawable.ic_nav2, (int) R.drawable.ic_nav2_sel));
        al.add(new Data("Recipes", (int) R.drawable.ic_nav3, (int) R.drawable.ic_nav3_sel));
        al.add(new Data("Categories", (int) R.drawable.ic_nav4, (int) R.drawable.ic_nav4_sel));
        al.add(new Data("Profile", (int) R.drawable.ic_nav5, (int) R.drawable.ic_nav5_sel));
        al.add(new Data("Settings", (int) R.drawable.ic_nav6, (int) R.drawable.ic_nav6_sel));
        return al;
    }

    private void launchFragment(int pos) {
        Fragment f = null;
        String title = null;
        if (pos == 2) {
            title = "Recipes";
            f = new RecipeList();
        } else if (pos == 3) {
            title = "Categories";
            f = new CategoryList();
        }
        if (f != null) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f).addToBackStack(title).commit();
            if (this.adapter != null) {
                this.adapter.setSelection(pos);
            }
        }
    }

    private void setupContainer() {
        getSupportFragmentManager().addOnBackStackChangedListener(new OnBackStackChangedListener() {
            public void onBackStackChanged() {
                MainActivity.this.setActionBarTitle();
            }
        });
        launchFragment(2);
    }

    private void setActionBarTitle() {
        if (this.drawerLayout.isDrawerOpen(this.drawerLeft)) {
            getActionBar().setTitle(R.string.app_name);
        } else if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getActionBar().setTitle(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName());
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.drawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.drawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
            return true;
        }
        finish();
        return true;
    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.logout) {
            startActivity(new Intent(this, Login.class));
            finish();
        }
    }
}
