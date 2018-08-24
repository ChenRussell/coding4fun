package com.nowcoder.designPattern.FactoryPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle :: draw() method.");
    }
}
