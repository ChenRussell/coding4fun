package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class _42_1_ReverseWordsInSentence {

    public String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        // 反转整个句子
        reverse(chars, 0, chars.length - 1);
        System.out.println(String.valueOf(chars));
        int head = 0, tail = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                tail = i;
//                continue;
            }
            if (chars[i] == ' ' || i+1 == chars.length){
                reverse(chars, head, tail);
                head = i + 1;
            }
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _42_1_ReverseWordsInSentence reverseSentence = new _42_1_ReverseWordsInSentence();
        String res = reverseSentence.reverseSentence("how are you!");
        System.out.println(res);
    }
}
