package com.nowcoder.zhenti;

import org.hamcrest.core.Is;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-3-13
 *
 *  邻边相等且对角线相等的四边形是正方形.
 */
public class IsSquare {
    public boolean isSquare (int p1[],int p2[],int p3[],int p4[]){
        int p[][]={{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int cnt=0;
        int  len[]=new int[6];
        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=3;j++){
                // p[i][0]是第i个点的x坐标;p[j][1]是第j个点的y坐标
                len[cnt++]=(p[i][0]-p[j][0])*(p[i][0]-p[j][0])+(p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
            }

        }
        //数组排序 最长的是对角线
        Arrays.sort(len);
        //相邻两边相等,对角线相等的四边形是正方形;
        if(len[0]==len[1]&&len[1]==len[2]&&len[4]==len[5]&&len[4]>len[1]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int p1[] = {0, 0},p2[]={0,1},p3[]={1,0},p4[]={1,1};
        boolean square = new IsSquare().isSquare(p1, p2, p3, p4);
        System.out.println(square);
    }
}
