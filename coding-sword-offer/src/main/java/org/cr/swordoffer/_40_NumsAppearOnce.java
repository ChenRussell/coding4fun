package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-18
 * ��Ŀ����
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * Ҫ��ʱ�临�Ӷ�Ϊo(n),�ռ临�Ӷ�Ϊo(1)
 */
public class _40_NumsAppearOnce {

    /**
     * //num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
     * //��num1[0],num2[0]����Ϊ���ؽ��
     * @param array
     * @param num1
     * @param num2
     */
    static public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length <2) return;
        int resultExclusiveOR = 0;

        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }

        int indexof1 = FindFirstBitIs1(resultExclusiveOR);

        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (IsBit1(array[i], indexof1))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }


    }

    static private boolean IsBit1(int num, int indexBit) {
        num = num >> indexBit;
        return ((num & 1)==1);
    }

    static private int FindFirstBitIs1(int num) {

        int indexBit = 0;
        while (((num & 1) == 0)) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public static void main(String[] args) {
        int array[] = {2, 4, 3, 6, 3, 2, 6, 5};
        int num1[] = {0};
        int num2[] = {0};

        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
