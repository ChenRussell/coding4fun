package org.cr.designpattern.AdapterPattern;

/**
 * Created by ChenRui on 18-3-8
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //ʲôҲ����
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

