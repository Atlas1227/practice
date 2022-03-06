package sort;

import java.util.Arrays;

/*
选择排序
每次选择最小数放在前面
循环n-1次
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 8); //生成一个[0, 8000000) 数
        }
        System.out.println("愿数组为"+ Arrays.toString(arr));
        selectSort(arr);
    }
    public static void selectSort(int[] arr){
        //循环n-1次
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=arr[i];
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int temp;
            temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
            //优化，发生交换才赋值
//            if(minIndex!=i){
//                temp=arr[i];
//                arr[i]=arr[minIndex];
//                arr[minIndex]=temp;
//            }
            System.out.println("第"+(i+1)+"趟排序后数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
