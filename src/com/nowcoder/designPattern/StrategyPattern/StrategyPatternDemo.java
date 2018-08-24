package com.nowcoder.designPattern.StrategyPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context1 = new Context(new OperationAdd());
        System.out.println(context1.executeStrategy(10, 5));

        Context context2 = new Context(new OperationSubstract());
        System.out.println(context2.executeStrategy(10, 5));

        Context context3 = new Context(new OperationMutiply());
        System.out.println(context3.executeStrategy(10, 5));
    }
}
