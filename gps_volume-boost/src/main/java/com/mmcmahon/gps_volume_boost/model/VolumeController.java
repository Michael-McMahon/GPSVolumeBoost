package com.mmcmahon.gps_volume_boost.model;

import android.content.Context;

/**
 * Created by Mike on 4/24/2014.
 */
public interface VolumeController {
    /**
     * Initialize this class by obtaining a reference to the audio stream
     * for which volume will be controlled.
     * @return True if initialization succeeded, false otherwise.
     */
    public boolean init(Context context);

    /**
     * Set the volume for the audio stream associated to this VolumeController
     */
    public void setVolume(int volume);
}
