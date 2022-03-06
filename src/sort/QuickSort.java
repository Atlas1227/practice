package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//		int[] arr = {-9,78,0,23,5671,70, -1,900, 4561};
//		int[] arr = {6, 5, 3, 2,2, 1,0,8,7};
        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
//		System.out.println("arr=" + Arrays.toString(arr));
    }
    /*快速排序，给定目标数组，选择中轴数、左右起始位置。从左右开始寻找，将小于中轴数和大于中轴数的元素交换，直至左右两边
    分别为大于中轴数和小于中轴数的S元素，递归进行，完成数组排序*/
    public static void quickSort(int[] arr,int left,int right){
        int l=left;//左下标
        int r=right;//右下标
        int temp;//辅助交换变量
        //取中轴数
        int pivot=arr[(left+right)/2];
        while(l<r){
            //寻找左边大于中轴数的元素
            while(arr[l]<pivot){
                l++;
            }
            //寻找右边小雨中轴数的元素
            while(arr[r]>pivot){
                r--;
            }
            //当左右下标相交时，停止循环
            while(l>=r){
                break;
            }
            //交换元素
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //交换完，当arr[l]=pivot时，防止l不移动
            if (arr[l]==pivot){
                l++;
            }
            if (arr[r]==pivot){
                r--;
            }
        }
        //防止数组越界造成栈溢出，中轴数位置不变
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            quickSort(arr, left, r);
        }
        //向右递归
        if (right>l){
            quickSort(arr, l, right);
        }
    }
}
