/**
 * 德才论 (25)
时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述
宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之

小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”



现给出一批考生的德才分数，请根据司马光的理论给出录取排名。

输入描述:
输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分和才分均不低于L的考生才有资格

被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到

但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼

亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。


随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，德才分为区间[0, 100]内的整数。数字间以空格分隔。


输出描述:
输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人

总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。

输入例子:
14 60 80

10000001 64 90

10000002 90 60

10000011 85 80

10000003 85 80

10000004 80 85

10000005 82 77

10000006 83 76

10000007 90 78

10000008 75 79

10000009 59 90

10000010 88 45

10000012 80 100

10000013 90 99

10000014 66 60

输出例子:
12

10000013 90 99

10000012 80 100

10000003 85 80

10000011 85 80

10000004 80 85

10000007 90 78

10000006 83 76

10000005 82 77

10000002 90 60

10000014 66 60

10000008 75 79

10000001 64 90
 */
package com.nowcoder.zhenti;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VirtueAndTalentTheoryV3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int H = sc.nextInt();
		
		ArrayList<Stu> both = new ArrayList<Stu>();
		ArrayList<Stu> dc1 = new ArrayList<Stu>();
		ArrayList<Stu> dc2 = new ArrayList<Stu>();
		ArrayList<Stu> dc3 = new ArrayList<Stu>();
		
		while(N!=0){
			Stu stu = new Stu(sc.nextInt(),sc.nextInt(),sc.nextInt());
			if(stu.d<L || stu.c<L){
				N--;
				continue;
			}
			if(stu.d>=H && stu.c>=H){
				both.add(stu);
			}
			else if(stu.d>=H){
				dc1.add(stu);
			}
			else if(stu.d>=stu.c){
				dc2.add(stu);
			}
			else{
				dc3.add(stu);
			}
			N--;
		}
		Collections.sort(both,new Comparator<Stu>() {

			@Override
			public int compare(Stu o1, Stu o2) {
				// TODO Auto-generated method stub
				if(o1.sum!=o2.sum) return o2.sum-o1.sum;
				if(o1.d!=o2.d) return o2.d-o1.d;
				return o1.id-o2.id;
			}
		});
		Collections.sort(dc1,new Comparator<Stu>() {
			
			@Override
			public int compare(Stu o1, Stu o2) {
				// TODO Auto-generated method stub
				if(o1.sum!=o2.sum) return o2.sum-o1.sum;
				if(o1.d!=o2.d) return o2.d-o1.d;
				return o1.id-o2.id;
			}
		});
		Collections.sort(dc2,new Comparator<Stu>() {
			
			@Override
			public int compare(Stu o1, Stu o2) {
				// TODO Auto-generated method stub
				if(o1.sum!=o2.sum) return o2.sum-o1.sum;
				if(o1.d!=o2.d) return o2.d-o1.d;
				return o1.id-o2.id;
			}
		});
		Collections.sort(dc3,new Comparator<Stu>() {
			
			@Override
			public int compare(Stu o1, Stu o2) {
				// TODO Auto-generated method stub
				if(o1.sum!=o2.sum) return o2.sum-o1.sum;
				if(o1.d!=o2.d) return o2.d-o1.d;
				return o1.id-o2.id;
			}
		});
//		Collections.sort(dc1);
//		Collections.sort(dc2);
//		Collections.sort(dc3);
		System.out.println(both.size()+dc1.size()+dc2.size()+dc3.size());
		print(both);
		print(dc1);
		print(dc2);
		print(dc3);
		sc.close();
	}
	
	private static void print(ArrayList<Stu> set){
		for(Stu s:set){
			System.out.println(s.id+" "+s.d+" "+s.c);
		}
	}
	
	static class Stu{
		int id,d,c,sum;
		public Stu(int id, int d, int c){
			this.id = id;
			this.d = d;
			this.c = c;
			this.sum = d+c;
		}
	}
}

//import java.util.Scanner;
//
//public class VirtueAndTalentTheory {
//	
//	public static void main(String[] args) {
//		int N,L,H;
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		L = sc.nextInt();
//		H = sc.nextInt();
//		Integer arr[][] = new Integer[N][4];
//		Integer arr2[][] = new Integer[N+1][4];
//		for(int i=0; i<N; i++){
//			arr[i][0] = sc.nextInt();
//			arr[i][1] = sc.nextInt();
//			arr[i][2] = sc.nextInt();
//			arr[i][3] = arr[i][1]+arr[i][2];
//		}
//		for(int i=0; i<N; i++){
//			arr2[i][0] = 0;
//			arr2[i][1] = 0;
//			arr2[i][2] = 0;
//			arr2[i][3] = 0;
//		}
//		
//		int index = 0;
//		//第一类
//		for(int i=0;i<N;i++){
//			if(arr[i][1]>=H && arr[i][2]>=H){
//				for(int j=index;j>=0;j--){
//					if(arr[i][3]>arr2[j][3]){
//						arr2[j+1] = arr2[j];
//						arr2[j] = arr[i];
//					}else{
//						arr2[j+1]=arr[i];
//					}
//				}
//				index++;
//			}
//		}
//		//第二类
//		for(int i=0;i<N;i++){
//			if(arr[i][1]>=H && arr[i][2]<H){
//				for(int j=index;j>=0;j--){
//					if(arr[i][3]>arr2[j][3]){
//						arr2[j+1] = arr2[j];
//						arr2[j] = arr[i];
//					}else{
//						arr2[j+1]=arr[i];
//					}
//				}
//				index++;
//			}
//		}
//		//第三类
//		for(int i=0;i<N;i++){
//			if(arr[i][1]<H && arr[i][1]>=L && arr[i][2]<H && arr[i][2]>=L && arr[i][1]>=arr[i][2]){
//				for(int j=index;j>=0;j--){
//					if(arr[i][3]>arr2[j][3]){
//						arr2[j+1] = arr2[j];
//						arr2[j] = arr[i];
//					}else{
//						arr2[j+1]=arr[i];
//					}
//				}
//				index++;
//			}
//		}
//		//第四类
//		for(int i=0;i<N;i++){
//			if(!(arr[i][1]<H && arr[i][1]>=L && arr[i][2]<H && arr[i][2]>=L && arr[i][1]>=arr[i][2]) && !(arr[i][1]>=H && arr[i][2]<H) && !(arr[i][1]>=H && arr[i][2]>=H)){
//				for(int j=index;j>=0;j--){
//					if(arr[i][3]>arr2[j][3]){
//						arr2[j+1] = arr2[j];
//						arr2[j] = arr[i];
//					}else{
//						arr2[j+1]=arr[i];
//					}
//				}
//				index++;
//			}
//		}
//		
//		System.out.println(index);
//		for(int i=0;i<N;i++){
//			System.out.println(arr2[i][0]+" "+arr2[i][1]+" "+arr2[i][2]);
//		}
//	}
//	
//}
