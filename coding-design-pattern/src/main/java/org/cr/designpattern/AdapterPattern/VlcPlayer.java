package org.cr.designpattern.AdapterPattern;

/**
 * Created by ChenRui on 18-3-8
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //ʲôҲ����
    }
}
