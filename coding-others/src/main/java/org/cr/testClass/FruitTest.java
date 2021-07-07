package org.cr.testClass;

public class FruitTest {

    static class Fruit {}

    private static class Apple extends Fruit{}

    private static class Arrange extends Fruit{}

    private static class BigApple extends Apple {}

    public static void main(String[] args) {
        Fruit[] arr = new Apple[10];

        try {

            arr[0] = new Fruit();
            System.out.println("add fruit success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("add fruit failed");
        }
        try {

            arr[0] = new Arrange();
            System.out.println("add arrange success");
        } catch (Exception e) {
            System.out.println("add arrange failed");
        }

        try {
            arr[0] = new BigApple();    //�����滻ԭ�� �κ�ʱ�򶼿����������ʹ��游����!
            System.out.println("add big apple successfully");
        } catch (Exception e) {
            System.out.println("add big apple failed");
        }
    }
}
