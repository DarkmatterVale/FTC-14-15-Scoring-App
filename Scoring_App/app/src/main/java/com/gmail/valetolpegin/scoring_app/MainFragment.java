package com.gmail.valetolpegin.scoring_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {
    private Button mCalculateDC;
    private Button mCalculateAutonomous;
    private EditText mCurrentTotal;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        getActivity().setTitle(R.string.app_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_main, parent, false );

        mCalculateDC = (Button)v.findViewById( R.id.main_driver_controlled_button );
        mCalculateAutonomous = (Button)v.findViewById( R.id.main_autonomous_button );
        mCurrentTotal = (EditText)v.findViewById( R.id.main_current_total );

        mCalculateDC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                //Add code here
            }
        });

        mCalculateAutonomous.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v )
            {
                //Add code here
            }
        });

        return v;
    }
}