package com.example.nyeineieitun.mycallapp;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nyeineieitun.mycallapp.Fragments.StartFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null ) {
            StartFragment startFragment  = new StartFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.root_layout, startFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
