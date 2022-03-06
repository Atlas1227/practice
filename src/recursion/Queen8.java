package recursion;

public class Queen8 {
    int max=8;
    int[] array=new int[max];
    private int count=0;
    private int judgeCount;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("解法总数0"+ queen8.count);
        System.out.println("一共判断位置次数"+queen8.judgeCount);

    }
    //摆放皇后位置

    /**
     *
     * @param n 摆放第n个皇后
     */
     private void check(int n){
        if (n==max){
            print();
            return;
        }
        //在第n行依次放入皇后
         for (int i = 0; i < max; i++) {
             array[n]=i;
             //判断位置都否冲突
             if(judge(n)){
                 //不冲突摆放下一个皇后
                 check(n+1);
             }
         }
     }

    //判断皇后位置是否冲突

    /**
     *
     * @param n 第n个皇后
     * @return 返回判断结果
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //输出皇后释放位置
    private void print(){
        count++;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
