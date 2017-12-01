package com.itcast.basic.designpatterntype.adaptor;

import com.itcast.basic.designpatterntype.adaptor.service.MediaPlayer;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class AudioPlayer implements MediaPlayer {


    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            MediaPlayer mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
