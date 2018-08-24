package com.nowcoder.swordoffer;


/**
 * 替换空格
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * 考察的是C语言的字符的移动，需要使用指针，使用java没有意义
     * @param str
     * @return
     */
    public String repaceSpace2(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') count++;
        }
        int len = chars.length + count*2;   // 计算需要使用总的空间
        return "";
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are happy.");
        String s = new ReplaceBlankSpace().replaceSpace(stringBuffer);
        System.out.println(s);
    }
}


/**
 * 问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
 * 问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
 * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
 * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
 */
