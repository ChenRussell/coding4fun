package org.cr.juc.kkb;

import java.util.concurrent.Phaser;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding-for-offer
 * @date 2021/07/08
 */
public class PhaserTest {
    public static void main(String[] args) {
        int parties = 3;
        int phases = 4;
        final Phaser phaser = new Phaser(parties) {
            @Override
            //ÿ���׶ν���ʱ
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("====== Phase : " + phase + "  end ======");
                return registeredParties == 0;
            }
        };
        for (int i = 0; i < parties; i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                for (int phase = 0; phase < phases; phase++) {
                    if (phase == 0) {
                        System.out.println(String.format("��һ�׶β���  Thread %s, phase %s", threadId, phase));
                    }
                    if (phase == 1) {
                        System.out.println(String.format("�ڶ��׶β���  Thread %s, phase %s", threadId, phase));
                    }
                    if (phase == 2) {
                        System.out.println(String.format("�����׶β���  Thread %s, phase %s", threadId, phase));
                    }
                    if (phase == 3) {
                        System.out.println(String.format("���Ľ׶β���  Thread %s, phase %s", threadId, phase));
                    }
                    /**
                     * arriveAndAwaitAdvance() ��ǰ�̵߳�ǰ�׶�ִ����ϣ��ȴ������߳���ɵ�ǰ�׶Ρ�
                     * �����ǰ�߳��Ǹý׶����һ��δ����ģ���÷���ֱ�ӷ�����һ���׶ε���ţ��׶���Ŵ�0��ʼ����
                     * ͬʱ�����̵߳ĸ÷���Ҳ������һ���׶ε���š�
                     **/
                    int nextPhaser = phaser.arriveAndAwaitAdvance();

                }
            });
            thread.start();
        }
    }
}
