package com.gmail.valetolpegin.scoring_app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DriverControlledOptions extends android.app.DialogFragment {
    private EditText mCenterGoalHeight;
    private EditText mLargeGoalHeight;
    private EditText mMediumGoalHeight;
    private EditText mSmallGoalHeight;
    private EditText mNumberInParkingZone;
    private EditText mNumberInRamp;
    private EditText mCurrentTotal;

    private int currentTotal = 0;
    private int centerGoalHeight    = 0;
    private int largeGoalHeight     = 0;
    private int mediumGoalHeight    = 0;
    private int smallGoalHeight     = 0;
    private int numberInParkingZone = 0;
    private int numberInRamp        = 0;

    private getCurrentTotalListener currentTotalListener;

    public interface getCurrentTotalListener
    {
        public void getCurrentTotalDC( int value );
    }

    @Override
    public void onAttach( Activity activity )
    {
        super.onAttach( activity );

        currentTotalListener = (getCurrentTotalListener) activity;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        currentTotalListener.getCurrentTotalDC( currentTotal );
    }

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View v = inflater.inflate( R.layout.fragment_driver_controlled_options, parent );

        getDialog().setTitle( "Driver Controlled" );

        currentTotal = 0;

        mCenterGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_centerGoal_count );
        mLargeGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_largeGoal_count );
        mMediumGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_mediumGoal_count );
        mSmallGoalHeight = (EditText)v.findViewById( R.id.driver_controlled_smallGoal_count );
        mNumberInParkingZone = (EditText)v.findViewById( R.id.driver_controlled_parkingZone );
        mNumberInRamp = (EditText)v.findViewById( R.id.driver_controlled_ramp );
        mCurrentTotal = (EditText)v.findViewById( R.id.driver_controlled_currentTotal );

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
                try
                {
                    centerGoalHeight = 6 * Integer.parseInt(mCenterGoalHeight.getText().toString());
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mCenterGoalHeight.getText().toString() );
                }
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

            public void afterTextChanged( Editable c ) {
                try
                {
                    largeGoalHeight = 3 * Integer.parseInt(mLargeGoalHeight.getText().toString());
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mLargeGoalHeight.getText().toString() );
                }
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
                try
                {
                    mediumGoalHeight = 2 * Integer.parseInt(mMediumGoalHeight.getText().toString());
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mMediumGoalHeight.getText().toString() );
                }
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

            public void afterTextChanged( Editable c )
            {
                try
                {
                    smallGoalHeight = Integer.parseInt(mSmallGoalHeight.getText().toString());
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText( "" + currentTotal );
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mSmallGoalHeight.getText().toString() );
                }
            }
        });

        mNumberInParkingZone.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                //Add watcher code here
            }

            public void beforeTextChanged(CharSequence c, int start, int before, int count) {
                //Add watcher code here
            }

            public void afterTextChanged(Editable c) {
                try
                {
                    numberInParkingZone = 10 * Integer.parseInt(mNumberInParkingZone.getText().toString());
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mNumberInParkingZone.getText().toString() );
                }
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
                try
                {
                    numberInRamp = 30 * Integer.parseInt( mNumberInRamp.getText().toString() );
                    currentTotal = centerGoalHeight + largeGoalHeight + mediumGoalHeight + smallGoalHeight + numberInParkingZone + numberInRamp;
                    mCurrentTotal.setText( "" + currentTotal );
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mNumberInRamp.getText().toString() );
                }
            }
        });

        return v;
    }
}