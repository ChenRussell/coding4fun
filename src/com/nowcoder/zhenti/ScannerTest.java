package com.nowcoder.zhenti;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String [] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("请输入你的年龄："); 
        int age = sc.nextInt(); 
        sc.nextLine();
        System.out.println("请输入你的姓名："); 
        String name = sc.nextLine();
        /**
         * next()方法不接受空格，nextLine()方法会吸收回车键
         */
        String name2 = sc.nextLine();
        System.out.println("请输入你的工资："); 
        float salary = sc.nextFloat(); 
        System.out.println("你的信息如下："); 
        System.out.println("姓名："+name+"\n"+name2+"\n"+"年龄："+age+"\n"+"工资："+salary); 
}
}
