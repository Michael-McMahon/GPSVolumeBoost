package com.mmcmahon.gps_volume_boost;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mmcmahon.gps_volume_boost.model.VolumeCalculator;


public class ACTV_ConfigVolumeBoost extends Activity implements Controller{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_volume_boost);
        //Create volume calculator
        //Create volume controller
        //Instantiate location service
        //Set location listener
    }

    /**SpeedListener will call this method when a location update is received*/
    public void setSpeed(int newSpeed)
    {
        //Set volume level based on speed
    }
}
