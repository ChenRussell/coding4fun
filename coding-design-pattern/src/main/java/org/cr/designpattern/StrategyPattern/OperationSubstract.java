package org.cr.designpattern.StrategyPattern;

/**
 * Created by ChenRui on 18-3-9
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOpration(int num1, int num2) {
        return num1 - num2;
    }
}
