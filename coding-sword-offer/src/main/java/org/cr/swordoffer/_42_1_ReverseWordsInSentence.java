package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * ��Ŀ����
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class _42_1_ReverseWordsInSentence {

    public String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        // ��ת��������
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
