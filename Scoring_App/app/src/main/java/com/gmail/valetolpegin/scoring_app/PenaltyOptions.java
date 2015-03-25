package com.gmail.valetolpegin.scoring_app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PenaltyOptions extends android.app.DialogFragment {
    private EditText mPenaltyMajor;
    private EditText mPenaltyMinor;
    private EditText mPenaltyCurrentTotal;

    private int currentTotal = 0;
    private int numberMajorPenalties = 0;
    private int numberMinorPenalties = 0;

    private getCurrentTotalListenerPenalties currentTotalListener;

    public interface getCurrentTotalListenerPenalties
    {
        public void getCurrentTotalPenalties( int value );
    }

    @Override
    public void onAttach( Activity activity )
    {
        super.onAttach( activity );

        currentTotalListener = (getCurrentTotalListenerPenalties) activity;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        currentTotalListener.getCurrentTotalPenalties( currentTotal );
    }

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View v = inflater.inflate( R.layout.fragment_penalty, parent );

        getDialog().setTitle( "Penalties" );

        currentTotal = 0;

        mPenaltyMinor = (EditText)v.findViewById( R.id.penalty_minor );
        mPenaltyMajor = (EditText)v.findViewById( R.id.penalty_major );
        mPenaltyCurrentTotal = (EditText)v.findViewById( R.id.penalties_current_total );

        mPenaltyMinor.addTextChangedListener( new TextWatcher() {
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
                    numberMinorPenalties = -10 * Integer.parseInt(mPenaltyMinor.getText().toString());
                    currentTotal = numberMinorPenalties + numberMajorPenalties;
                    mPenaltyCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mPenaltyCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mPenaltyMinor.getText().toString() );
                }
            }
        });

        mPenaltyMajor.addTextChangedListener( new TextWatcher() {
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
                    numberMajorPenalties = -50 * Integer.parseInt(mPenaltyMajor.getText().toString());
                    currentTotal = numberMinorPenalties + numberMajorPenalties;
                    mPenaltyCurrentTotal.setText("" + currentTotal);
                } catch ( NumberFormatException e )
                {
                    mPenaltyCurrentTotal.setText( "ERROR! PLEASE ENTER A NUMBER, NOT:" + mPenaltyMajor.getText().toString() );
                }
            }
        });

        return v;
    }
}