package org.cr.p20201013;

/**
 * @Description
 * @auther chenrui
 * @create 2020-10-15 15:51
 */
public class GetNumOfK {

    public int getNumOfK(int[] arr, int k) {
        int start = findFirst(arr, k);
        int end = findLast(arr, k);
        return end - start + 1;
    }

    public int findFirst(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (arr[middle] == k) {
                if (middle == 0 || arr[middle - 1] != k) {
                    return middle;
                } else high = middle - 1;
            } else if (arr[middle] < k) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return 0;
    }

    public int findLast(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (arr[middle] == k) {
                if (middle == arr.length-1 || arr[middle + 1] != k) {
                    return middle;
                } else low = middle + 1;
            } else if (arr[middle] < k) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        GetNumOfK getNumOfK = new GetNumOfK();
        int[] arr = new int[]{1,3, 3, 3, 3, 3,5};
        int result = getNumOfK.getNumOfK(arr, 3);
        System.out.println(result);
    }
}
