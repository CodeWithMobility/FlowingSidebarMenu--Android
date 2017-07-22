package com.mobiledev.flowingsidebarmenu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mobiledev.flowingsidebarmenu.flowingsidemenu.DrawerFragment;
import com.mobiledev.flowingsidebarmenu.flowingsidemenu.DrawerLayout;
import com.mobiledev.flowingsidebarmenu.flowingsidemenu.FlowingView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mLeftDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        mLeftDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);

        FragmentManager fm = getSupportFragmentManager();
        DrawerFragment mMenuFragment = (DrawerFragment) fm.findFragmentById(R.id.id_container_menu);
        FlowingView mFlowingView = (FlowingView) findViewById(R.id.sv);
        if (mMenuFragment == null) {
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment = new DrawerFragment()).commit();
        }
        mLeftDrawerLayout.setFluidView(mFlowingView);
        mLeftDrawerLayout.setMenuFragment(mMenuFragment);
    }
    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mLeftDrawerLayout.isShownMenu()) {
            mLeftDrawerLayout.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
