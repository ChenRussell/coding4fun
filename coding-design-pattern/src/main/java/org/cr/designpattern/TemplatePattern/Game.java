package org.cr.designpattern.TemplatePattern;

/**
 * Created by ChenRui on 18-4-13
 */
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // ģ��
    public final void play() {
        // ��ʼ����Ϸ
        initialize();
        // ��ʼ��Ϸ
        startPlay();
        // ������Ϸ
        endPlay();
    }
}
