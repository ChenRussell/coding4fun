package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-18
 *
 * ��Ŀ����n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n��
 * ��ӡ��s���п��ܵ�ֵ���ֵĸ���
 *
 * ˼·��
 * Ӧ�ö�̬�滮��
 * ����������ӽṹΪ:F(k,n)��ʾk�����ӵ�����Ϊn��������k��ʾ���Ӹ�����n��ʾk�����ӵĵ�����
 * F(k,n) = F(k-1,n-1)+F(k-1,n-2)+F(k-1,n-3)+F(k-1,n-4)+F(k-1,n-5)+F(k-1,n-6), ����k>0,k<=n<=6*k
 * F(k,n) = 0, ����n<k or n>6*k
 * ��k=1, F(1,1)=F(1,2)=F(1,3)=F(1,4)=F(1,5)=F(1,6)=1
 *
 * �����湫ʽ���Կ�����k�����ӵ�����Ϊn������ֻ��k-1�����ӵĺ��йء���Ϳ����õ�����¼�ķ�����
 * ��һ�ű�񱣴��ѽ����������Ľ⣬Ȼ���Ե�����������ǵ���ǰ��ļ���ֻ����һ���йأ����ֻ�豣��һ�С�
 */
public class _43_DicesProbability {

    static final int FACE_NUMBER = 6; // ���ӵ�����

    /**
     * �������ܣ�n�����ӵĵ���
     * ����������number is number of touzi
     * @param number
     */
    static void printProbability(int number) {

        if(number <= 0) return;

        int dp[] = new int[number * FACE_NUMBER + 1]; // dp[j]��ʾ��Ϊj��������

        double total = Math.pow(6.0, number);
        int size = number * FACE_NUMBER;

        // initialize
        dp[0] = 0;
        for (int i = 1; i <= FACE_NUMBER; i++) {
            dp[i] = 1;
        }
        for (int i = FACE_NUMBER + 1; i <= size; i++) {
            dp[i] = 0;
        }

        for (int i = 2; i <= number; i++) { // ���ӵĸ�����2��number
            // �Ӻ���ǰ��ֵ�����⽫��һ���Ԫ�ظ��ǵ����Ӷ�ֻ��Ҫʹ��һ������
            for (int j = i * FACE_NUMBER; j >= i; j--) { // i�����Ӻ͵ķ�ΧΪ [i, i*FACE_NUMBER]
                dp[j] = 0;
                for (int k = 1; k <= 6 && j >= k; k++) {
                    dp[j] += dp[j - k];
                }
            }

            // for impossible cases:����С�����ӵĸ���
            for (int j = i - 1; j >= 0; j--) {
                dp[j] = 0;
            }
        }

        for (int i = 0; i <= size; i++) {
            System.out.println("sum= "+i +" ,p=" + String.format("%.8f", dp[i]/total));
        }
    }

    public static void main(String[] args) {
        printProbability(8);
    }
}
