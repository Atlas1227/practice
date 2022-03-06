package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

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

		shellSort(arr); //交换式
//        shellSort2(arr);//移位方式
//
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }
/*    希尔排序是插入排序的一种，又称为最小增量排序。使用增量将目标数组分组，然后对每个子组进行插入排序。
    增量不断减小，数组有序度不断增加。最终，增量为1.*/

    //交换法进行插入
    public static void shellSort(int[] arr){
        int temp;
        //第一个循环，增量gap不断减小至1
        for (int gap = arr.length/2; gap >0 ; gap=gap/2) {
            //第二个循环，交叉遍历各个子组元素
            for (int i = gap; i < arr.length ; i++) {
                //第三个循环
                for (int j = i-gap; j >=0 ; j-=gap) {
                    //判断当前元素和当前子组的后一个元素大小，小的放前面
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }
    //移位法进行排序
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int j=i;//j赋值变化，j就是待插入下标
                int temp=arr[j];
                if (arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }
}
