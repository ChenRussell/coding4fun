package org.cr.designpattern.FactoryPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method. ");
    }
}
