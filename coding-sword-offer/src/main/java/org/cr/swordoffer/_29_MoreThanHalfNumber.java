package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/4/5
 * Ŀ����
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class _29_MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 1;
        int flag = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != flag) {
                count--;
            } else count++;
            if (count == 0) {
                flag = array[i];
                count = 1;
            }
        }
//        System.out.println(count);
        // �ٱ���һ��
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == flag) count++;
        }
        if (count*2>array.length) return flag;
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int arr2[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int arr3[] = {2,2,2,2,2,1,3,4,5};
        int res = new _29_MoreThanHalfNumber().MoreThanHalfNum_Solution(arr3);
        System.out.println(res);
    }
}
