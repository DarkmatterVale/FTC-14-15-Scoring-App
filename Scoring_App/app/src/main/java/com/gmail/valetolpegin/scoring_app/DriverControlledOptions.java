package com.gmail.valetolpegin.scoring_app;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DriverControlledOptions extends Fragment {
    private EditText mCenterGoalHeight;
    private EditText mLargeGoalHeight;
    private EditText mMediumGoalHeight;
    private EditText mSmallGoalHeight;
    private EditText mNumberInParkingZone;
    private EditText mNumberInRamp;
    private EditText mCurrentTotal;

    private int currentTotal;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View v = inflater.inflate( R.layout.fragment_driver_controlled_options, parent, false );

        currentTotal = 0;

        mCenterGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_centerGoal_count );
        mLargeGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_largeGoal_count );
        mMediumGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_mediumGoal_count );
        mSmallGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_smallGoal_count );
        mNumberInParkingZone = (EditText)v.findViewById( R.id.driver_controlled_parkingZone );
        mNumberInRamp = (EditText)v.findViewById( R.id.driver_controlled_currentTotal );

        mCenterGoalHeight.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
               //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( Editable c )
            {
                //Add watcher code here
            }
        });

        mLargeGoalHeight.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( Editable c )
            {
                //Add watcher code here
            }
        });

        mMediumGoalHeight.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( Editable c )
            {
                //Add watcher code here
            }
        });

        mSmallGoalHeight.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }
        });

        mNumberInParkingZone.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( Editable c )
            {
                //Add watcher code here
            }
        });

        mNumberInRamp.addTextChangedListener( new TextWatcher() {
            public void onTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void beforeTextChanged( CharSequence c, int start, int before, int count )
            {
                //Add watcher code here
            }

            public void afterTextChanged( Editable c )
            {
                //Add watcher code here
            }
        });

        return v;
    }
}