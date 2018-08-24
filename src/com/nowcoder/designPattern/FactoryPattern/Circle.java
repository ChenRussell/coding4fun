package com.nowcoder.designPattern.FactoryPattern;

import sun.security.provider.SHA;

/**
 * Created by ChenRui on 18-3-9
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method. ");
    }
}
