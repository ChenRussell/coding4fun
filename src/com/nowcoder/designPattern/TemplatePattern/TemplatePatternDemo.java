package com.nowcoder.designPattern.TemplatePattern;

/**
 * Created by ChenRui on 18-4-13
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println("*****************");

        game = new Football();
        game.play();
    }
}
