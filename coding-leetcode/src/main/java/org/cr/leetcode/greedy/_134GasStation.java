package org.cr.leetcode.greedy;

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
            tank += gas[i] - cost[i];   // tank ��ʾʣ���gas
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        // gas���ܺʹ��ڵ���cost���ܺͣ���ô�϶���һ����
        if (gasSum < costSum) return -1;
        return startIndex;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0; i < n; i++){
            int totalFuel = 0;
            int stopCount = 0, j = i;
            while(stopCount < n){
                totalFuel += gas[j % n] - cost[j % n];
                if(totalFuel < 0) break; // whenever we reach -ve
                stopCount++;
                j++;
            }
            if(stopCount == n && totalFuel >= 0) return i; // cover all the stops & our fuel left is 0 or more than that
        }
        return -1;
    }


        public static void main(String[] args) {
        int gas[] = {8,5,6};
        int cost[] = {6,8,5};
        int res = new _134GasStation().canCompleteCircuit(gas, cost);
        System.out.println(res);

    }
}
