package com.nowcoder.leetcode.greedy;

/**
 * Created by ChenRui on 18-4-8
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
 *
 * its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class _134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = 0, costSum = 0, tank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];   // tank 表示剩余的gas
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        // gas的总和大于等于cost的总和，那么肯定有一个解
        if (gasSum < costSum) return -1;
        return startIndex;
    }

    public static void main(String[] args) {
        int gas[] = {8,5,6};
        int cost[] = {6,8,5};
        int res = new _134GasStation().canCompleteCircuit(gas, cost);
        System.out.println(res);

    }
}
