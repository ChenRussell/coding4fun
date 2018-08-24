package com.nowcoder.campusExam.beike;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by ChenRui on 2018/8/18
 * <p>
 * 在中国某大学内，教室资源十分紧张，有n个社团同时申请了在某一天使用同一间教室，假设第i个社团占用该教室的时间记为[li,  ri]。根据学校的规定，教务部门必须且最多取消一个社团的预约，来满足另外n-1个社团的需求，问学校有多少种取消的方案。(若两社团占用时间分别为[l1, r1]和[l2,  r2]，此时若r1=l2，视为时间没有冲突)
 * <p>
 * 输入
 * 第一行包含一个整数n，表示社团的数量。(1≤n≤5000)。
 * <p>
 * 接下来有n行，每行包含两个整数，表示第i个社团占用该教室的时间为[li, ri](1≤li, ri≤106)
 * <p>
 * 输出
 * 输出第一行包含一个整数m，表示可以删去的社团数量。
 * <p>
 * 输出第二行包含m个整数，分别为可删除的社团编号(从小到大排序)。
 * <p>
 * （如不删除某个预约，则不能算作一种方案。）
 * <p>
 * <p>
 * 样例输入
 * 3
 * 3 10
 * 20 30
 * 1 3
 * 样例输出
 * 3
 * 1 2 3
 * <p>
 * Hint
 * 输入样例2
 * 4
 * 3 10
 * 20 30
 * 1 3
 * 1 39
 * <p>
 * 输出样例2
 * 1
 * 4
 * <p>
 * 输入样例3
 * 3
 * 1 5
 * 2 6
 * 3 7
 * <p>
 * 输出样例3
 * 0
 * <p>
 * 样例解释
 * 样例1中删除 1，2 ，3社团中的任何一个都可以使得另外两个社团无冲突的使用教室
 * 样例2中删除4以后【1，3】【3，10】【20，30】无冲突，若删除1，2，3中任何一个都会与4冲突。
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
