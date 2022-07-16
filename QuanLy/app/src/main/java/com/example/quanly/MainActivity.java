package com.example.quanly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quanly.fragment.donhang_fragment;
import com.example.quanly.fragment.loaisanpham_fragment;
import com.example.quanly.fragment.sanpham_fragment;
import com.example.quanly.fragment.taikhoan_fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_TAIKHOAN = 0 ;
    private static final int FRAGMENT_SANPHAM = 1 ;
    private static final int FRAGMENT_LOAISANPHAM = 2 ;
    private static final int FRAGMENT_DONHANG = 3 ;

    private  int mCurentFragment =  FRAGMENT_TAIKHOAN ;
    private DrawerLayout mDrawerLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar
                ,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new taikhoan_fragment());
        navigationView.getMenu().findItem(R.id.nav_taiKhoan).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();
        if(id==R.id.nav_taiKhoan){
            if(mCurentFragment != FRAGMENT_TAIKHOAN){
                replaceFragment(new taikhoan_fragment());
                mCurentFragment = FRAGMENT_TAIKHOAN ;
            }
        }else if (id==R.id.nav_sanPham){
            if(mCurentFragment != FRAGMENT_SANPHAM){
                replaceFragment(new sanpham_fragment());
                mCurentFragment = FRAGMENT_SANPHAM ;
            }

        }else if (id==R.id.nav_loaiSanPham){
            if(mCurentFragment != FRAGMENT_LOAISANPHAM){
                replaceFragment(new loaisanpham_fragment());
                mCurentFragment = FRAGMENT_LOAISANPHAM ;
            }

        }else if (id==R.id.nav_donHang){
            if(mCurentFragment != FRAGMENT_DONHANG){
                replaceFragment(new donhang_fragment());
                mCurentFragment = FRAGMENT_DONHANG ;
            }

        }else if(id==R.id.thoat){

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
}