package com.itcast.basic.designpatterntype.adaptor;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class AdapterServiceClient {
    public static void main(String[] args) {
        try {
            AudioPlayer audioPlayer = new AudioPlayer();

            audioPlayer.play("mp3", "beyond the horizon.mp3");
            audioPlayer.play("mp4", "alone.mp4");
            audioPlayer.play("vlc", "far far away.vlc");
            audioPlayer.play("avi", "mind me.avi");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
