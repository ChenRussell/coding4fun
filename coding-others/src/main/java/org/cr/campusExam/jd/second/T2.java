package org.cr.campusExam.jd.second;

/**
 * Created by ChenRui on 2018/9/9
 */
public class T2 {

    public static void main(String[] args) {
        System.out.println(Test2.a);
    }
}

class Test2 {

    // 读取被final修饰、已在编译期把结果放入常量池的静态的静态字段  ---不会触发类的初始化
    public static final String a = "JD";  // ????????????
//    public static final String a = new String("JD");  // ????????????
    static {
        System.out.println("OK");
    }


}
