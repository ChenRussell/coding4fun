package org.cr.swordoffer;


/**
 * �滻�ո�
 * ��Ŀ����
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class _4_ReplaceBlankSpace {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * �������C���Ե��ַ����ƶ�����Ҫʹ��ָ�룬ʹ��javaû������
     * @param str
     * @return
     */
    public String repaceSpace2(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') count++;
        }
        int len = chars.length + count*2;   // ������Ҫʹ���ܵĿռ�
        return "";
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are happy.");
        String s = new _4_ReplaceBlankSpace().replaceSpace(stringBuffer);
        System.out.println(s);
    }
}


/**
 * ����1���滻�ַ���������ԭ�����ַ��������滻�������¿���һ���ַ������滻��
 * ����2���ڵ�ǰ�ַ����滻����ô�滻�Ÿ���Ч�ʣ�������java�����е�replace��������
 * ��ǰ�����滻��������ַ�Ҫ���������ƶ���Ҫ����ƶ�������Ч�ʵ���
 * �Ӻ���ǰ���ȼ�����Ҫ���ٿռ䣬Ȼ��Ӻ���ǰ�ƶ�����ÿ���ַ�ֻΪ�ƶ�һ�Σ�����Ч�ʸ���һ�㡣
 */
