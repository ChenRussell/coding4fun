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

    // ��ȡ��final���Ρ����ڱ����ڰѽ�����볣���صľ�̬�ľ�̬�ֶ�  ---���ᴥ����ĳ�ʼ��
    public static final String a = "JD";  // ????????????
//    public static final String a = new String("JD");  // ????????????
    static {
        System.out.println("OK");
    }


}
