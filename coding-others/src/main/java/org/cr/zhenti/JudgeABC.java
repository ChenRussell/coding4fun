package org.cr.zhenti;
/**
 * ��Ŀ����
��������[-2��31�η�, 2��31�η�]�ڵ�3������A��B��C�����ж�A+B�Ƿ����C��

��������:
�����1�и���������T(<=10)���ǲ��������ĸ�����������T�����������ÿ��ռһ�У�˳�����A��B��C���������Կո�ָ���


�������:
��ÿ�������������һ���������Case #X: true�����A+B>C�����������Case #X: false��������X�ǲ��������ı�ţ���1��ʼ����

��������:
4

1 2 3

2 3 4

2147483647 0 2147483646

0 -2147483648 -2147483647

�������:
Case #1: false

Case #2: true

Case #3: true

Case #4: false
 * @author ChenRui
 *
 */

// ����������һ�����һ����Ҳ���Զ�����֮�������
import java.util.Scanner;
public class JudgeABC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;	// num<=10
		String str = "";
		num = sc.nextInt();
		sc.nextLine();
		if(num<=10){
		String[] strs = new String[num];
		// ���������ַ�
		for(int i=0;i<num;i++){
			strs[i] = sc.nextLine();
//			sc.nextLine();           �ַ���֮�䲻�ý��ܻس�����
//			System.out.println(strs[i]);
//			String[] split = strs[i].split(" ");
//			int a = Integer.parseInt(split[0]);
//			int b = Integer.parseInt(split[1]);
//			int c = Integer.parseInt(split[2]);
//			long a,b,c;
//			a = Long.parseLong(split[0]);
//			b = Long.parseLong(split[1]);
//			c = Long.parseLong(split[2]);
//			boolean boo;
//			boo=(a + b > c);
//			System.out.println("Case #"+(i+1)+": "+boo);
		}


		//�ж�
		for(int i = 0; i < num; i++){
			String[] split = strs[i].split(" ");
			long a,b,c;
			a = Long.parseLong(split[0]);
			b = Long.parseLong(split[1]);
			c = Long.parseLong(split[2]);
			boolean boo;
			boo=(a + b > c);
			System.out.println("Case #"+(i+1)+": "+boo);
		}
		}
	}
}
