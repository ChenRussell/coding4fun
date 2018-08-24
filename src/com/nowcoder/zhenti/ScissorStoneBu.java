package com.nowcoder.zhenti;

import java.util.Scanner;

/**
 * 锤子剪刀布 (20)
 时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
 题目描述
 大家应该都会玩“锤子剪刀布”的游戏：

 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。

 输入描述:
 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代

 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。


 输出描述:
 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯

 一，则输出按字母序最小的解。

 输入例子:
 10

 C J

 J B

 C B

 B B

 B C

 C C

 C B

 J B

 B C

 J J

 输出例子:
 5 3 2

 2 3 5

 B B
 */
public class ScissorStoneBu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int q=0,w=0,e=0;
        int jia[] = new int[3];
        int yi[] = new int[3];
        while(n>0){
            String a = sc.next();
            String b = sc.next();
//            System.out.println(a+" "+b);
            if(a.toCharArray()[0]=='C'&&b.toCharArray()[0]=='C'){
                w++;
            }
            if(a.toCharArray()[0]=='C'&&b.toCharArray()[0]=='J'){
                q++;
                jia[1]++;
            }
            if(a.toCharArray()[0]=='C'&&b.toCharArray()[0]=='B'){
                e++;
                yi[2]++;
            }
            if(a.toCharArray()[0]=='J'&&b.toCharArray()[0]=='C'){
                e++;
                yi[1]++;
            }
            if(a.toCharArray()[0]=='J'&&b.toCharArray()[0]=='J'){
                w++;
            }
            if(a.toCharArray()[0]=='J'&&b.toCharArray()[0]=='B'){
                q++;
                jia[0]++;
            }
            if(a.toCharArray()[0]=='B'&&b.toCharArray()[0]=='C'){
                q++;
                jia[2]++;
            }
            if(a.toCharArray()[0]=='B'&&b.toCharArray()[0]=='J'){
                e++;
                yi[0]++;
            }
            if(a.toCharArray()[0]=='B'&&b.toCharArray()[0]=='B'){
                w++;
            }
            n--;
        }
        System.out.println(q+" "+w+" "+e);
        System.out.println(e+" "+w+" "+q);
        int max = -1;
        int mark=-1;
        for(int i=0;i<jia.length;i++){
            if(jia[i]>=max){
                max = jia[i];
                mark = i;
            }
        }
        if(mark==0) System.out.print("J"+" ");
        if(mark==1) System.out.print("C"+" ");
        if(mark==2) System.out.print("B"+" ");
        mark=-1;
        max=-1;
        for(int i=0;i<yi.length;i++){
            if(yi[i]>=max){
                max = yi[i];
                mark = i;
            }
        }
        if(mark==0) System.out.print("J");
        if(mark==1) System.out.print("C");
        if(mark==2) System.out.print("B");
    }
}
