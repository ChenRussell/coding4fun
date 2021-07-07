package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 *
 * ��Ŀ����
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class _38GetNumberOfK {

    // ���ֲ���
    static public int getNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        int start = getFirstNode(array, k);
        int end = getLastNode(array, k);
        if (start > -1 && end > -1) return end - start + 1;
        else return 0;
    }

    // һ��ֻ����һ��
    private static int getFirstNode(int[] array, int k) {

        int low = 0, high = array.length-1;
        int middle;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (array[middle] == k) {
                if ((middle > 0 && array[middle - 1] != k)
                        || middle == 0) {
                    return middle;
                } else high = middle - 1;
            } else if (array[middle] < k) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;  // �Ҳ�������-1
    }

    private static int getLastNode(int[] array, int k) {

        int low = 0, high = array.length-1;
        int middle;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (array[middle] == k) {
                if ((middle+1 < array.length && array[middle + 1] != k)
                        || middle == array.length-1) {
                    return middle;
                } else low = middle + 1;
            } else if (array[middle] < k) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;  // �Ҳ�������-1
    }

    public static void main(String[] args) {
        int num[] = {3,3,3,3,3,3,3};
        int res = getNumberOfK(num, 3);
        System.out.println(res);
    }
}
