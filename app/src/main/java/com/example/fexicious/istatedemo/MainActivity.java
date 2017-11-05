package com.example.fexicious.istatedemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.fexicious.istatedemo.fragment.HittingPercentFragment;
import com.example.fexicious.istatedemo.fragment.PointsScoredFragment;
import com.example.fexicious.istatedemo.fragment.SkillSummaryFragment;

public class MainActivity extends AppCompatActivity {
    final Fragment hitFragment = new HittingPercentFragment();
    final Fragment skillFragment = new SkillSummaryFragment();
    final Fragment pointFragment = new PointsScoredFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = hitFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.frame_layout, pointFragment, "3").commit();
        fm.beginTransaction().add(R.id.frame_layout, skillFragment, "2").commit();
        fm.beginTransaction().add(R.id.frame_layout, hitFragment, "1").commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_hitting_percent:
                    if(active != hitFragment)
                        fm.beginTransaction().hide(active).show(hitFragment).commit();
                    active = hitFragment;
                    break;
                case R.id.navigation_skill_summary:
                    if(active != skillFragment)
                        fm.beginTransaction().hide(active).show(skillFragment).commit();
                    active = skillFragment;
                    break;
                case R.id.navigation_points_scored:
                    if(active != pointFragment)
                        fm.beginTransaction().hide(active).show(pointFragment).commit();
                    active = pointFragment;
                    break;
            }
            return true;
        }
    };


}
