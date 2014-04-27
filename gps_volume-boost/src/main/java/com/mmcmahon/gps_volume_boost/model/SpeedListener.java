package com.mmcmahon.gps_volume_boost.model;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.mmcmahon.gps_volume_boost.Controller;

/**
 * Created by Mike on 4/15/2014.
 */
public class SpeedListener implements LocationListener {
    //The current location
    private Location currentLoc;
    private Controller control;

    /**
     * Create a new SpeedListener which will send speeds to the supplied
     * MusicStreamSetter.
     * @param c Controller which receives speed updates
     */
    public SpeedListener(Controller c)
    {
        control = c;
    }

    /**
     * Update the current location. This class will calculate the device's
     * speed based off the new location. Speed will be sent to MusicStreamSetter.
     * @param newLoc The new location
     */
    public void onLocationChanged(Location newLoc)
    {
        int speed;
        //Update the current location
        Location oldLoc = currentLoc;
        //Set the current location to the new location supplied
        currentLoc = newLoc;

        /*Don't attempt to calculate speed if doing so requires an old and new
         location*/
        if(oldLoc == null && !newLoc.hasSpeed())
        {
            return;
        }
        //Get Speed, rounding float to integer
        speed = Math.round(SpeedCalculator.getSpeed(oldLoc, newLoc));
        //Send speed to controller
        control.setSpeed(speed);
    }

    public void onProviderDisabled(String provider)
    {
        //Alert user that provider has been disabled
    }

    public void onProviderEnabled(String provider)
    {
        //Re-initialize
    }

    /**
     * Called when the provider status changes. This method is called when a
     * provider is unable to fetch a location or if the provider has recently
     * become available after a period of unavailability.
     * @param provider
     * @param status OUT_OF_SERVICE if the provider is out of service, and
     *               this is not expected to change in the near future;
     *               TEMPORARILY_UNAVAILABLE if the provider is temporarily
     *               unavailable but is expected to be available shortly; and
     *               AVAILABLE if the provider is currently available.
     * @param extras
     */
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        //Alert user to the status
    }
}
