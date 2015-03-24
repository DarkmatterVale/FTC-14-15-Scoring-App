package com.gmail.valetolpegin.scoring_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {
    private android.app.Fragment mAutonomousFragment;
    private android.app.Fragment mDriverControlledFragment;
    private android.app.Fragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.FragmentManager fm = getFragmentManager();
        mMainFragment = fm.findFragmentById( R.id.fragmentContainer );

        if ( mMainFragment == null )
        {
            mMainFragment = new MainFragment();

            fm.beginTransaction()
                    .add( R.id.fragmentContainer, mMainFragment )
                    .commit();
        }
    }
}
