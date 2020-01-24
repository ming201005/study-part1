package com.chapter07.testsort;

/**
  算法
   1）低位优先键索引排序
   2）高位优先建索引排序  MSD类
   3）优化Java的归并排序 Arrays.sort(arr);
   4）冒泡排序
   5）快速排序
   6）三向快速排序 Quick3string类
 时间复杂度：
   最慢的肯定是冒泡，O(n的平方)
   最快的是快速排序，平均 O(nlogn)
   低位优先，O(nW),W是字符串长度，
   在字符串长度较短情况下和快速排序时间应该很接近
   高位优先，O(n) - O(nW)
   三向快速排序，O(n) - O(nW)
 稳定的排序是：
   低位优先键索引排序
   高位优先建索引排序
   归并排序（Java自带的排序算法），速度还行，
   关键是保持循环情况下的顺序稳定
 */
public class testSort {


    /**
     * 1。低位优先键索引排序
     * @param a
     * @param w
     */
    public static void sort(String[] a, int w) {
        int n = a.length;
        // extend ASCII alphabet size
        int R = 256;
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }


    /**
     * 冒泡
     * @param arr
     */
    public static void bubblingSort(String[] arr) {
        int size = arr.length;
        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<arr.length; j++) {
                if(arr[i].compareTo(arr[j])>0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(String[] arr,int left,int right)
    {
        String  f,t;
        int rtemp,ltemp;
        ltemp=left;
        rtemp=right;
        //分界值
        f = arr[(left+right)/2];
        while(ltemp<rtemp){
            while(arr[ltemp].compareTo(f)<0){
                ++ltemp;
            }
            while(arr[rtemp].compareTo(f)>0){
                --rtemp;
            }
            if(ltemp<=rtemp) {
                t=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=t;
                --rtemp;
                ++ltemp;
            }
        }
        if(ltemp==rtemp){
            ltemp++;
        }
        if(left<rtemp) {
            //递归调用
            quickSort(arr,left,ltemp-1);
        }
        if(ltemp<right) {
            //递归调用
            quickSort(arr,rtemp+1,right);
        }
    }

}
