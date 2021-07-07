package org.cr.campusExam.ctrip.second_ctrip;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int A = sc.nextInt();
        List<S> list = new ArrayList<>();
        for(int i = 0;i < num;i++) {
            int id = sc.nextInt();
            int in = sc.nextInt();
            int out = sc.nextInt();
            S s =new S(id,in,out);
            list.add(s);
        }
//        Comparator c = new Comparator<S>() {
//
//            @Override
//            public int compare(S arg0, S arg1) {
//                // TODO Auto-generated method stub
//                return arg0.id - arg1.id;
//            }
//
//        };
//        list.sort(c);
        Collections.sort(list);
        boolean f = false;
//        for(int i = 0;i < num;i ++) {
//            S sh = list.get(i);
//            if(sh.in <= A && sh.out >= A){
//                System.out.println(sh.id);
//                f = true;
//            }
//
//        }
        for (S sh : list) {
            if(sh.in <= A && sh.out >= A){
                System.out.println(sh.id);
                f = true;
            }
        }
        if(!f) System.out.println("null");

    }
    static class S implements Comparable {
        int id;
        int in;
        int out;
        public S(int id, int in, int out) {
            this.id = id;
            this.in = in;
            this.out = out;
        }



        @Override
        public int compareTo(Object o) {
            o = (S) o;
            return this.id -((S) o).id;
        }
    }
}
