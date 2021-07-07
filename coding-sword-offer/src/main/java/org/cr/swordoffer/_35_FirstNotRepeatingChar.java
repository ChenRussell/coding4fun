package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-23
 *
 * ��Ŀ����
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 */

public class _35_FirstNotRepeatingChar {

    public static int firstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        int hashTable[] = new int[200];
        for (int i = 0; i < arr.length; i++) {
            hashTable[arr[i]]++;
        }

//        for (int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i] == 1) {
//                return i;
//            }
//        }
        // ���ַ�����˳�����
        for (int i = 0; i < arr.length; i++) {
            if (hashTable[arr[i]] == 1) {
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "google";
        int res = firstNotRepeatingChar(str);
        System.out.println((char)res);
        System.out.println(str.indexOf(res));
    }
}
