package com.gmail.valetolpegin.scoring_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements
        DriverControlledOptions.getCurrentTotalListener,
        AutonomousOptions.getCurrentTotalListenerAutonomous,
        PenaltyOptions.getCurrentTotalListenerPenalties {
    private Button mCalculateDC;
    private Button mCalculateAutonomous;
    private Button mCalculatePenalties;

    private EditText mCurrentTotal;

    private android.app.DialogFragment autonomousOptions;
    private android.app.DialogFragment driverControlledOptions;
    private android.app.DialogFragment penaltyOptions;

    private int currentTotalDC = 0;
    private int currentTotalAutonomous = 0;
    private int currentTotalPenalties = 0;

    @Override
    public void getCurrentTotalPenalties( int value )
    {
        currentTotalPenalties = value;

        mCurrentTotal.setText( "" + ( currentTotalDC + currentTotalAutonomous + currentTotalPenalties ) );
    }

    @Override
    public void getCurrentTotalAutonomous( int value )
    {
        currentTotalAutonomous = value;

        mCurrentTotal.setText( "" + ( currentTotalDC + currentTotalAutonomous + currentTotalPenalties ) );
    }

    @Override
    public void getCurrentTotalDC( int value )
    {
        currentTotalDC = value;

        mCurrentTotal.setText( "" + ( currentTotalDC + currentTotalAutonomous + currentTotalPenalties ) );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.app.FragmentManager fm = getFragmentManager();

        mCalculateDC = (Button)findViewById( R.id.main_driver_controlled_button );
        mCalculateAutonomous = (Button)findViewById( R.id.main_autonomous_button );
        mCalculatePenalties = (Button)findViewById( R.id.main_penalty_button );
        mCurrentTotal = (EditText)findViewById( R.id.main_current_total );

        autonomousOptions = new AutonomousOptions();
        driverControlledOptions = new DriverControlledOptions();
        penaltyOptions = new PenaltyOptions();

        mCalculateDC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                driverControlledOptions.setRetainInstance( true );
                driverControlledOptions.show( fm, "" );
            }
        });

        mCalculateAutonomous.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                autonomousOptions.setRetainInstance( true );
                autonomousOptions.show( fm, "@string/main_title" );
            }
        });

        mCalculatePenalties.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                penaltyOptions.setRetainInstance( true );
                penaltyOptions.show( fm, "" );
            }
        });
    }
}