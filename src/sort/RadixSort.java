package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}
/*
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
*/

        radixSort(arr);

/*        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);*/

        System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //求取最大数
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //获得最大数长度，循环内使用
        int maxLength=(max+"").length();
        //初始化10个桶
        int[][] bucket=new int[10][arr.length];
        //初始化一个数组用来记录桶中的数字
        int[] bucketElementCounts = new int[10];
        //基数排序，从个位数开始
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //放入桶中
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            //从同中拿出
            int index=0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j]!=0){
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++]=bucket[j][k];
                    }
                }
                //将桶中元素置空
                bucketElementCounts[j]=0;
            }

        }
    }
}
