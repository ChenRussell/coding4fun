/**
 * ���ӣ�https://www.nowcoder.com/questionTerminal/5e7d025e91ab468f909cb93d431b89c3
��Դ��ţ����

[�����]�м���PAT��25��
�ȶ�ָ����4081ʱ�����ƣ�1��ռ����ƣ�32768K
 �㷨֪ʶ��Ƶ����
�ַ���APPAPT�а������������ʡ�PAT�������е�һ��PAT�ǵ�2λ(P),��4λ(A),��6λ(T)���ڶ���PAT�ǵ�3λ(P),��4λ(A),��6λ(T)��

�ָ����ַ�������һ�������γɶ��ٸ�PAT��
��������:

����ֻ��һ�У�����һ���ַ��������Ȳ�����105��ֻ����P��A��T������ĸ��


�������:

��һ������������ַ����а������ٸ�PAT�����ڽ�����ܱȽϴ�ֻ�����1000000007ȡ�����Ľ����
ʾ��1
����

APPAPT
���

2
 */
package org.cr.zhenti;

import java.util.Scanner;

public class CountPAT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] arr = str.toCharArray();

		int p = 0, pa=0, pat=0;
		for (char c : arr) {
			if(c == 'P') {
				p++;
			}else if(c == 'A'){
				pa += p;
			}else if(c == 'T') {
				pat += pa;
				pat = pat % 1000000007;
			}
		}

		System.out.println("p: "+p);
		System.out.println("pa: "+pa);
		System.out.println("pat: "+pat);
	}
}
