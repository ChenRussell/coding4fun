package com.nowcoder.designPattern.StrategyPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOpration(num1, num2);
    }
}
