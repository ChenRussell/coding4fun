package com.nowcoder.designPattern.StrategyPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class OperationMutiply implements Strategy {
    @Override
    public int doOpration(int num1, int num2) {
        return num1*num2;
    }
}
