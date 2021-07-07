package org.cr.leetcode.dynamicProgramming;

import static java.lang.Integer.max;

/**
 * Created by ChenRui on 2018/4/1
 * <p>
 * �Ӵ�Ӧ�ñȽϺ���⣬����ʲô�������У��������һ�����ӣ�������ĸ��
 * <p>
 * cnblogs
 * belong
 * ��������bo, bg, lg��ĸ��cnblogs��belong�ж����ֹ����ҳ���˳����ĸ������һ�£����ǽ����Ϊ���������С�
 * ����������У�Longest Common Subsequence, LCS��������˼�壬��ָ�����е��������������һ����
 * �Ӵ���Ҫ����ϸ��һ�������У�Ҫ����ĸ���������س��֡����������ӵ��У������������Ϊblog��cnblogs, belong����
 * ������Ӵ�Ϊlo��cnblogs, belong����
 */
public class LCS {

    /**
     * �����������
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    public static void main(String[] args) {
        int lcs = LCS.lcs("cnblogs", "belong");
        System.out.println(lcs);
    }
}
