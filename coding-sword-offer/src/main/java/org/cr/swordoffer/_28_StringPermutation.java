package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenRui on 2018/4/5
 * ��Ŀ����
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
 * ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * ��������:
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 */
public class _28_StringPermutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        ArrayList<Character> tempList = new ArrayList<>();
        boolean used[] = new boolean[chars.length];
        backTracking(res, tempList, chars, used);
        return res;
    }

    private void backTracking(ArrayList<String> res, ArrayList<Character> tempList, char[] chars, boolean used[]) {

        if (tempList.size() == chars.length && !res.contains(String.valueOf(tempList.toString()))) {
            res.add(tempList.toString());
        } else {

            for (int i = 0; i < chars.length; i++) {
                if (used[i]) continue;
                tempList.add(chars[i]);
                used[i] = true;
                backTracking(res, tempList, chars, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    static public ArrayList<String> permutation2(String str) {
        ArrayList<String> res = new ArrayList<>();
        permutation2(str.toCharArray(), res, 0);
        return res;
    }

    private static void permutation2(char[] chars, ArrayList<String> res, int begin) {
        if (String.valueOf(chars).length() - 1 == begin) {
            res.add(String.valueOf(chars));
        }

        for (int i = begin; i < chars.length; i++) {
            char temp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = temp;

            permutation2(chars, res, begin + 1);

            temp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> res = new _28_StringPermutation().permutation(str);
//        List<String> res = permutation2(str);
//        System.out.println(res);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
