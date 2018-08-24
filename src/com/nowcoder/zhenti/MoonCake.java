/**
 * 月饼 (25)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需

求量，请你计算可以获得的最大收益是多少。



注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、

72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得

 72 + 45/2 = 94.5（亿元）。

输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数

D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿

元为单位）。数字间以空格分隔。


输出描述:
对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。

输入例子:
3 20

18 15 10

75 72 45

输出例子:
94.50
 */
package com.nowcoder.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoonCake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int category,demand;
		double result = 0;
		category = sc.nextInt();
		demand = sc.nextInt();
		List<Integer> list1 = new ArrayList<Integer>();//存储每种月饼的库存量
		List<Integer> list2 = new ArrayList<Integer>();//存储每种月饼的总售价
		List<Double> list3 = new ArrayList<Double>();//存储每种月饼的单价
		for(int i=0;i<category;i++){
			list1.add(sc.nextInt());
		}
		for(int i=0;i<category;i++){
			list2.add(sc.nextInt());
		}
		for(int i=0;i<list1.size();i++){
			list3.add((double)(list2.get(i))/list1.get(i));
		}
		System.out.println(list3);
		while(true){
			double max = -1;
			int index = -1;
			for(int i=0;i<list3.size();i++){
				if(list3.get(i)>max) {
					max = list3.get(i);
					index = i;
				}
			}
//			list3.remove(index);
			if(list1.get(index)>demand){
				result = result + list3.get(index)*demand;
				break;
			}else{
				result = result + list2.get(index);
				demand = demand - list1.get(index);
			}
			list1.remove(index);
			list2.remove(index);
			list3.remove(index);
			if(list1.size()==0){
				break;
			}
		}
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  //保留两位小数
//		df.format(result);
		System.out.println(df.format(result));
	}
}
