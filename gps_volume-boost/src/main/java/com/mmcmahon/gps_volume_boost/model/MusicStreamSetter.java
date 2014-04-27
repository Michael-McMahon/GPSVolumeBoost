package com.mmcmahon.gps_volume_boost.model;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by Mike on 4/15/2014.
 */
public class MusicStreamSetter implements VolumeController{

    //volCtl provides access to the volume of audio streams
    AudioManager volCtl;

    public boolean init(Context context)
    {
        //Obtain a reference to the system's audio service
        volCtl = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if(volCtl == null)
        {
            return false;
        }

        return true;
    }

    public void setVolume(int volume)
    {
        //Set new volume on the music stream, with 0 flags set
        volCtl.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }

    /**
     * Return the maximum volume of the audio stream
     */
    public void getMaxVolume()
    {
        volCtl.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }
}
