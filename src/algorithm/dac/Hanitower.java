package algorithm.dac;

public class Hanitower {
    public static void main(String[] args) {
        hanoitower(10, 'A', 'B', 'C');
    }
    public static void hanoitower(int num,char a,char b,char c) {
        if (num == 1) {
            System.out.println("第1个盘由" + a + "->" + c);
        } else {
            hanoitower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘由" + a + "到" + c);
            hanoitower(num-1, b, a, c);
        }
    }
}

