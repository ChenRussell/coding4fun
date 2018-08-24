package com.nowcoder.designPattern.TemplatePattern;

/**
 * Created by ChenRui on 18-4-13
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized£¡ Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Start. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
