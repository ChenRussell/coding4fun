package com.nowcoder.designPattern.BridgePattern;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Circle[ color : red , radius: " + radius + ",x: " + x +",y: " + y);
    }
}
