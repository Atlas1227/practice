package recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test(9);
        int res=factorial(3);
        System.out.println("阶乘结果为"+res);
    }
    //打印问题
    public static void test(int n){
        if (n>1){
            test(n-1);
        }
        System.out.println("n="+n+"\n");
    }
    //阶乘问题
    public static int factorial(int n){
        if (n==1){
            return 1;
        }
        return factorial(n-1)*n;
    }
}
