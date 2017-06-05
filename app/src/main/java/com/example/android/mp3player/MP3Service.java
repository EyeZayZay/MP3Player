package com.example.android.mp3player;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by Android on 6/2/2017.
 */

public class MP3Service extends Service {

    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Uri myUri = Uri.parse("android.resource://com.example.android.mp3player/" + R.raw.davidbowiefame);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), myUri);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
