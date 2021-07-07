package org.cr.swordoffer;

/**
 * ��Ŀ����
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

/**
 * ����Ŀ������Ƕ��ֲ��ҵ�Ӧ��
 */
public class _8_MinInRotateArray {
    /**
     * �÷�����΢�Ż���ʱ�临�ӶȻ���O(n)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) return array[i + 1];
        }
        return array[0];
    }

    /**
     * Ӧ�ö��ֲ��ң�ʱ�临�Ӷ�ΪO(log(n))
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        int low = 0, high = array.length - 1;
        int middle;
//        int middle = 0;
        middle = 0;
        while (array[low] >= array[high]) {      // ȷ������ת����

            if (low + 1 == high) {
                middle = high;
                break;
            }

            middle = (low + high) / 2;

            if (array[low] == array[middle] && array[middle] == array[high])
                return minNumberInRotateArray(array);   // �������ֻ����˳����ң�����ʹ�ø÷���

            if (array[low] <= array[middle]) low = middle;
            else if(array[high] >= array[middle]) high = middle;
        }
        return array[middle];
    }



    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 1, 2};
        int[] array = {1, 0, 1, 1, 1};
//        int[] array = {3, 4, 5, 6, 7};
        int i = new _8_MinInRotateArray().minNumberInRotateArray2(array);
        System.out.println(i);
    }
}
