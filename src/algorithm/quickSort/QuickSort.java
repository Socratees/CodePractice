package algorithm.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
* @Description: 快速排序算法的实现
* @Param: 
* @Return: 
* @Author: liuzhibiao
* @Date: 2019/1/1
*/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*50);
        }
        System.out.println(Arrays.toString(arr));
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int j = partition(arr, left, right);
        quick_sort(arr, left, j - 1);
        quick_sort(arr, j + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp = arr[left];
        while (i < j) {
            while (i<j && arr[j]>tmp){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            while (i<j && arr[i]<tmp){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = tmp;
        return i;
    }
}
