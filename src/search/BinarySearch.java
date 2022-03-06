package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 10, 10, 13,14,15,16,17,18,19,20 };


        //
//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 10);
        System.out.println("resIndexList=" + resIndexList);
    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        //没有找到
        if(left>right){
            return -1;
        }
        int mid=(left + right) / 2;
        int midVal = arr[mid];
        if (findVal<midVal){//向左递归
            return binarySearch(arr, left, mid-1, findVal);
        }else if (findVal>midVal){//向右递归
            return binarySearch(arr, mid+1,right,findVal);
        }else{
            return mid;//找到返回下标
        }
    }
    //将所有相同的值都找出来
    public static List<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
        if (left>right){
            return new ArrayList<>();
        }
        int mid=(left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return binarySearch2(arr, mid+1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向左扫描
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                resIndexList.add(temp);
                temp-=1;
            }
            //将自身加入
            resIndexList.add(mid);
            //向右扫描
            temp=mid+1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }
    }
}
