package com.nowcoder.designPattern.TemplatePattern;

/**
 * Created by ChenRui on 18-4-13
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Starting playing!");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the Game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
