package search;

public class InsertSearch {
    public static void main(String[] args) {
        //		int [] arr = new int[100];
//		for(int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}

        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertSearch(arr, 0, arr.length - 1, 1234);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);

        //System.out.println(Arrays.toString(arr));
    }

    public static int insertSearch(int[] arr,int left,int right,int findVal) {
        //没有找到
        if(left>right||findVal>arr[arr.length-1]||findVal<arr[0]){
            return -1;
        }
        //自适应求mid值
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal<midVal){//向左递归
            return insertSearch(arr, left, mid-1, findVal);
        }else if (findVal>midVal){//向右递归
            return insertSearch(arr, mid+1,right,findVal);
        }else{
            return mid;//找到返回下标
        }
    }
}
