package codingPatterns.striversdesheet;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {


        int[] arr = {4,5,1,2,7,3};

        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        quickSort(arr, left, mid);
        quickSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] l = new int [mid-left+2];
        l[l.length-1] = Integer.MAX_VALUE;
        int[] r = new int [right-mid+1];
        r[r.length-1] = Integer.MAX_VALUE;

        int t =0;
        for(int i=left;i<mid+1; i++){
            l[t] = arr[i];
            t++;
        }
        t=0;
        for(int i=mid+1;i<=right; i++){
            r[t] = arr[i];
            t++;
        }

        int i =0;
        int j = 0;
        int k = left;

        while(k <= right && i < l.length && j < r.length) {
            if(l[i] <= r[j]){
                arr[k] = l[i];
                i++;
                k++;
            } else {
                arr[k] = r[j];
                j++;
                k++;
            }
        }

    }
}
