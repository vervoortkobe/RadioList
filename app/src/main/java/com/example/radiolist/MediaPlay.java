package com.example.radiolist;

import static com.example.radiolist.MainActivity.joefm;
import static com.example.radiolist.MainActivity.mnm;
import static com.example.radiolist.MainActivity.nostalgie;
import static com.example.radiolist.MainActivity.qmusic;
import static com.example.radiolist.MainActivity.radio1;
import static com.example.radiolist.MainActivity.radio2;
import static com.example.radiolist.MainActivity.stubru;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class MediaPlay {

    public static MediaPlayer mp = new MediaPlayer();
    private static final String TAG = "MyActivity";

    public static void PlayMedia() {

        if(mp != null && mp.isPlaying()) {
            mp.stop();
            mp.reset();
        } else {
            mp = new MediaPlayer();
        }
        try {
            if(joefm == true) mp.setDataSource("https://20723.live.streamtheworld.com/JOE.mp3");
            else if(mnm == true) mp.setDataSource("https://22653.live.streamtheworld.com/MNM_64.mp3");
            else if(nostalgie == true) mp.setDataSource("https://22673.live.streamtheworld.com/NOSTALGIEWHATAFEELING.mp3");
            else if(qmusic == true) mp.setDataSource("https://21223.live.streamtheworld.com/QMUSIC.mp3");
            else if(radio1 == true) mp.setDataSource("https://23553.live.streamtheworld.com/RADIO1_128.mp3");
            else if(radio2 == true) mp.setDataSource("https://22603.live.streamtheworld.com/RADIO_2_ANTWERP_128.mp3");
            else if(stubru == true) mp.setDataSource("https://21313.live.streamtheworld.com/STUDIO_BRUSSEL_128.mp3");
            else mp.setDataSource("https://20723.live.streamtheworld.com/JOE.mp3"); //else set joefm
            mp.prepare();
            mp.start();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void StopPlaying() {

        mp.release();
        mp = null;
    }
}
