package com.gmail.valetolpegin.scoring_app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class AutonomousOptions extends android.app.DialogFragment {
    private EditText mCenterGoalBalls;
    private EditText mBallsInRollingGoal;
    private EditText mCurrentTotal;
    private EditText mNumberInParkingZone;

    private CheckBox mKickstandDropped;
    private CheckBox mNumberInRamp;

    private int currentTotal = 0;
    private int centerGoalHeight = 0;
    private int ballsInRollingGoal = 0;
    private int numberInParkingZone = 0;
    private int numberInRamp = 0;
    private int kickstandDropped = 0;

    private getCurrentTotalListenerAutonomous currentTotalListener;

    public interface getCurrentTotalListenerAutonomous
    {
        public void getCurrentTotalAutonomous( int value );
    }

    @Override
    public void onAttach( Activity activity )
    {
        super.onAttach( activity );

        currentTotalListener = (getCurrentTotalListenerAutonomous) activity;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        currentTotalListener.getCurrentTotalAutonomous(currentTotal);
    }

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_autonomous_options, parent );

        getDialog().setTitle( "Autonomous" );

        currentTotal = 0;

        mCenterGoalBalls = (EditText)v.findViewById( R.id.autonomous_centerGoal_count );
        mBallsInRollingGoal = (EditText)v.findViewById( R.id.autonomous_ballsInGoal_count );
        mCurrentTotal = (EditText)v.findViewById( R.id.autonomous_currentTotal );
        mNumberInRamp = (CheckBox)v.findViewById( R.id.autonomous_driveOffRamp_checkbox );
        mKickstandDropped = (CheckBox)v.findViewById( R.id.autonomous_dropKickstand_checkbox );
        mNumberInParkingZone = (EditText)v.findViewById( R.id.autonomous_parkingZone );

        mCenterGoalBalls.addTextChangedListener( new TextWatcher() {
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
                    centerGoalHeight = 60 * Integer.parseInt(mCenterGoalBalls.getText().toString());
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mCenterGoalBalls.getText().toString() );
                }
            }
        });

        mBallsInRollingGoal.addTextChangedListener( new TextWatcher() {
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
                    ballsInRollingGoal = 30 * Integer.parseInt(mBallsInRollingGoal.getText().toString());
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mBallsInRollingGoal.getText().toString() );
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
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;                    mCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mCurrentTotal.setText("ERROR! PLEASE ENTER A NUMBER, NOT:" + mNumberInParkingZone.getText().toString());
                }
            }
        });

        mNumberInRamp.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked )
            {
                if ( isChecked )
                {
                    numberInRamp = 20;
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;                    mCurrentTotal.setText("" + currentTotal);
                } else
                {
                    numberInRamp = 0;
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;                    mCurrentTotal.setText("" + currentTotal);
                }
            }
        });

        mKickstandDropped.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked )
            {
                if ( isChecked )
                {
                    kickstandDropped = 30;
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;
                    mCurrentTotal.setText("" + currentTotal);
                } else
                {
                    kickstandDropped = 0;
                    currentTotal = centerGoalHeight + ballsInRollingGoal + numberInParkingZone + numberInRamp + kickstandDropped;
                    mCurrentTotal.setText("" + currentTotal);
                }
            }
        });

        return v;
    }
}