package com.mmcmahon.gps_volume_boost.model;

/**
 * Created by Mike on 4/16/2014.
 */
public class VolumeCalculator {
    /*The maximum speed which speed readings will be compared to. maxVolume is
     is obtained when a speed reading is equal to or greater than maxSpeed.*/
    private int maxSpeed;

    //The highest volume level to be returned from calculateVolume method
    private int maxVolume;

    //The lowest volume level to be returned from calculateVolume method
    private int minVolume;

    //The difference between the maximum and minimum volume
    private int volumeDiff;

    /**
     * Calculate volume level.
     * @param speed Reading which will be compared to the max speed
     * @return A volume level based on specified max speed, max volume, and min volume
     */
    public int calculateVolume(int speed)
    {
        /*The difference between the maximum and minimum volume is multiplied
         by the fraction of provided speed over maximum speed. That product is
         added to the minimum volume to get the desired volume.*/
        return volumeDiff * (speed / maxSpeed) + minVolume;
    }

    public void setMaxSpeed(int maxSpeed){this.maxSpeed = maxSpeed;}

    public void setMaxVolume(int maxVolume)
    {
        this.maxVolume = maxVolume;
        updateDiff();
    }

    public void setMinVolume(int minVolume)
    {
        this.minVolume = minVolume;
        updateDiff();
    }

    /**
     * Called when min or max volume is changed.
     */
    private void updateDiff()
    {
        volumeDiff = maxVolume - minVolume;
    }
}
