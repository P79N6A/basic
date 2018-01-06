package com.itcast.basic.designpatterntype.adaptor;

import com.itcast.basic.designpatterntype.adaptor.impl.Mp4Player;
import com.itcast.basic.designpatterntype.adaptor.impl.VlcPlayer;
import com.itcast.basic.designpatterntype.adaptor.service.AdvancedMediaPlayer;
import com.itcast.basic.designpatterntype.adaptor.service.MediaPlayer;

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}