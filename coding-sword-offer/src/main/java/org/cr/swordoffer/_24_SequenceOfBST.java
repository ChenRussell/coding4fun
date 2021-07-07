package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-3-28
 * <p>
 * ��Ŀ����
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class _24_SequenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length ==0) return false;
        int root = sequence[sequence.length - 1];

        boolean bool = checkBST(sequence, 0, sequence.length - 1);
        return bool;
    }

    boolean checkBST(int seq[], int start, int end) {
        if (start >=end) return true;   // tag-1 ����������end<0,��������start>=end
        int root = seq[end];
//        int tag=0;
//        boolean flag = false;
        int i;
        for (i = start; i < end; i++) {
            if (seq[i]>root) {
//                tag=i;
//                flag = true;    // �������ҵ�����root��
                break;
            }
        }

        // ���Ҳ��Ŵ���root��ʱ��tag=0, tag-1 ����ȥ�ᱨ��
        for (int j = i; j < end; j++) {
            if (seq[j]<root)
                return false;
        }
//        return true;
        boolean left=true;
//        if (end>0)
        left= checkBST(seq, start, i-1);

        boolean right = true;
//        if (end>0)
        right = checkBST(seq, i, end-1);

        return left && right ;

    }

    public static void main(String[] args) {
        int arr[] = {5,7,6,9,11,10,8};
//        int arr2[] = {4,6,7,5};
        _24_SequenceOfBST obj = new _24_SequenceOfBST();
        boolean bool = obj.checkBST(arr, 0, arr.length - 1);
        System.out.println(bool);
    }
}
