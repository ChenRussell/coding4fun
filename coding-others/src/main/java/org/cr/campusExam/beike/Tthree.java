package org.cr.campusExam.beike;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by ChenRui on 2018/8/18
 * <p>
 * ���й�ĳ��ѧ�ڣ�������Դʮ�ֽ��ţ���n������ͬʱ��������ĳһ��ʹ��ͬһ����ң������i������ռ�øý��ҵ�ʱ���Ϊ[li,  ri]������ѧУ�Ĺ涨�������ű��������ȡ��һ�����ŵ�ԤԼ������������n-1�����ŵ�������ѧУ�ж�����ȡ���ķ�����(��������ռ��ʱ��ֱ�Ϊ[l1, r1]��[l2,  r2]����ʱ��r1=l2����Ϊʱ��û�г�ͻ)
 * <p>
 * ����
 * ��һ�а���һ������n����ʾ���ŵ�������(1��n��5000)��
 * <p>
 * ��������n�У�ÿ�а���������������ʾ��i������ռ�øý��ҵ�ʱ��Ϊ[li, ri](1��li, ri��106)
 * <p>
 * ���
 * �����һ�а���һ������m����ʾ����ɾȥ������������
 * <p>
 * ����ڶ��а���m���������ֱ�Ϊ��ɾ�������ű��(��С��������)��
 * <p>
 * ���粻ɾ��ĳ��ԤԼ����������һ�ַ�������
 * <p>
 * <p>
 * ��������
 * 3
 * 3 10
 * 20 30
 * 1 3
 * �������
 * 3
 * 1 2 3
 * <p>
 * Hint
 * ��������2
 * 4
 * 3 10
 * 20 30
 * 1 3
 * 1 39
 * <p>
 * �������2
 * 1
 * 4
 * <p>
 * ��������3
 * 3
 * 1 5
 * 2 6
 * 3 7
 * <p>
 * �������3
 * 0
 * <p>
 * ��������
 * ����1��ɾ�� 1��2 ��3�����е��κ�һ��������ʹ���������������޳�ͻ��ʹ�ý���
 * ����2��ɾ��4�Ժ�1��3����3��10����20��30���޳�ͻ����ɾ��1��2��3���κ�һ��������4��ͻ��
 */
public class Tthree {

    public static void main(String[] args) throws IOException {
        new HashMap<>();
        Socket socket = new Socket("", 1222);
        socket.getOutputStream();
        socket.getInputStream();
        ServerSocket serverSocket = new ServerSocket(221);
        Socket accept = serverSocket.accept();
        accept.getInputStream();
        accept.getOutputStream();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < n; i++) {
//            int key = sc.nextInt();
//            int value = sc.nextInt();
//            map.put(key, value);
//        }
//        System.out.println(map);
        Integer arr[][] = new Integer[n][2];
//        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
//            Integer[] ints = new Integer[2];
//            ints[0] = sc.nextInt();
//            ints[1] = sc.nextInt();
//            list.add(ints);
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Integer[][] arr2 = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][0];
            arr[i][0] = -1;

            sort(arr);
            if (isValid(arr)) {
                count ++;
                list.add(i);

            }
            arr[i][0] = temp;
        }
        System.out.println(count);
        System.out.println(list);
    }

    private static boolean isValid(Integer[][] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i][1] > arr[i+1][0]) {
                return false;
            }
        }
        return true;
    }

    private static void sort(Integer[][] arr){
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] x, Integer[] y) {
                if(x[0] < y[0]){
                    return -1;
                } else if(x[0] > y[0]){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}
