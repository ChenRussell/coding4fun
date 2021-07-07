package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/4/5
 * ��Ŀ����
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,
 * �������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class _31_GreatestSumOfSubArrays {

    public int findGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < max) max = array[i];
//        }
        for (int i = 1; i < array.length; i++) {
            if (sum + array[i] > 0) {
                sum = sum + array[i];
                if (sum > max) max = sum;
            }
            else sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {6,-3,-2,7,-15,1,2,2};
        int res = new _31_GreatestSumOfSubArrays().findGreatestSumOfSubArray(arr);
        System.out.println(res);
    }
}
