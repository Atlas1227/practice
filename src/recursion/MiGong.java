package recursion;

public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        // 输出新地图
        System.out.println("小球走过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map 迷宮地圖
     * @param i 起始位置横坐标
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j]=2;
                //按照下右上左顺序走
                if (setWay(map, i+1, j)){
                    return true;
                }else if(setWay(map, i, j+1)){
                    return true;
                }else if(setWay(map, i-1, j)){
                    return true;
                }else if(setWay(map, i, j-1)){
                    return true;
                }else{
                    //该点不通，死路
                    map[i][j]=3;
                    return false;
                }

            }else{
                return false;
            }
        }

    }
}