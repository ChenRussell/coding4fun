package org.cr.swordoffer;

/**
 * @Description
 * @auther chenrui
 * @create 2021-01-11 23:48
 * <p>
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
public class _47_AddTwoNumbers {

    public int Add(int num1, int num2) {
        int sum, over;
        do {
            sum = num1 ^ num2;
            over = (num1 & num2) << 1;
            num1 = sum;
            num2 = over;
        } while (over != 0);
        return sum;
    }

    public static void main(String[] args) {
        _47_AddTwoNumbers obj = new _47_AddTwoNumbers();
        System.out.println(obj.Add(11, 32));
    }
}
