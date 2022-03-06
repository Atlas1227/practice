package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 8); //生成一个[0, 8000000) 数
        }
        System.out.println("愿数组为"+Arrays.toString(arr));
        bubbleSort(arr);
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        //循环n-1次，
        for (int i = 0; i < arr.length-1; i++) {
            int temp=0;//辅助变量
            boolean flag=false;//用于判断是否发生交换，提前结束循环
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后数组");
            System.out.println(Arrays.toString(arr));
            if (!flag){
                System.out.println("已经得到结果，结束循环");
                break;
            }
        }
    }
}
