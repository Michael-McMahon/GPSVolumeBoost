package com.mmcmahon.gps_volume_boost.model;

import android.location.Location;
import android.os.Build;

/**
 * Created by Mike on 4/16/2014.
 */
public class SpeedCalculator {
    /**
     * Get speed at which device is moving. If the calling the method
     * hasSpeed() on endLoc returns true, this method will return the value
     * of calling getSpeed() on endLoc.
     * @param startLoc The starting location
     * @param endLoc The ending location
     * @return The device's speed in meters per second
     */
    public static float getSpeed(Location startLoc, Location endLoc)
    {
        float distM;
        long timeS;

        //Use provided speed, if it exists
        if(endLoc.hasSpeed())
        {
            return endLoc.getSpeed();
        }

        //Get time difference is seconds
        timeS = getTimeDifference(startLoc, endLoc);
        //Get distance traveled in meters
        distM = startLoc.distanceTo(endLoc);

        return distM / timeS;
    }

    private static long getTimeDifference(Location startLoc, Location endLoc)
    {
        long timeMS;

        //SDK 17 provides the more accurate getElapsedRealtimeNanos method
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //(long)0.000001  converts nanoseconds to milliseconds
            timeMS = (long)0.000001 * (startLoc.getElapsedRealtimeNanos() -
                    endLoc.getElapsedRealtimeNanos());
        }
        else
        {
            timeMS = startLoc.getTime() - endLoc.getTime();
        }

        //(long)0.001 converts milliseconds to seconds
        return (long)0.001 * timeMS;
    }
}
