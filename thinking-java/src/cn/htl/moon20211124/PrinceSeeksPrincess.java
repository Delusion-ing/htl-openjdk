package cn.htl.moon20211124;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CreateTime 2021/11/24 hushujing
 * <p>
 * 在一个n行m列的二维地图中，王子的位置为(x1,y1),公主的位置为(x2,y2)。
 * 在地图中设有一些障碍物，王子只能朝上、下、左、右四个方向行走，且不允许走出地图也不允许穿越障碍物。
 * 请编写一个程序判断王子是否可以顺利走到公主所在的位置。
 */
public class PrinceSeeksPrincess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        int count = Integer.parseInt(nextLine);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nextLine = scanner.nextLine();
            int m = Integer.parseInt(nextLine.split(" ")[0]);
            int n = Integer.parseInt(nextLine.split(" ")[1]);

        }
    }

    /**
     * Prince STEP1 起点值
     */
    public static int[] findStart(char[][] map) {
        int[] ints = new int[2];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 'S') {
                    map[row][col] = '.';
                    ints[0] = row;
                    ints[1] = col;
                }
            }
        }
        return ints;
    }

    /** STEP2 搜索迷宫路径 */
    public static boolean findWay(char[][] map, int row, int col) {
        if (map[row][col] == 'E') {
            return true;
        }
        if (map[row][col] == '.') {
            map[row][col] = ',';
            if ((row + 1) < map.length && findWay(map, row + 1, col)) {
                return true;
            }
            if ((row - 1) >= 0 && findWay(map, row - 1, col)) {
                return true;
            }
            if ((col + 1) < map[0].length && findWay(map, row + 1, col)) {
                return true;
            }
            if ((col - 1) >= 0 && findWay(map, row - 1, col)) {
                return true;
            }else {
                map[row][col] = '#';
                return false;
            }
        }
        return false;
    }


}
