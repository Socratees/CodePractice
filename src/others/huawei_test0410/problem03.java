package others.huawei_test0410;

import java.util.Scanner;

public class problem03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        problem03 p = new problem03();
        int[][] flag = new int[m][n];
        int c = p.countPaths(flag, map, x1, y1, x2, y2, m, n);
        System.out.println(c % (int)Math.pow(10,9));
//        System.out.println(Integer.MAX_VALUE);
    }

    public int countPaths(int[][] flag, int[][] map, int x1, int y1, int x2, int y2, int m, int n) {
        int count = 0;
        if (x1 == x2 && y1 == y2) {
            return 1;
        }

        if (x1 - 1 >= 0 && map[x1 - 1][y1] > map[x1][y1] && flag[x1 - 1][y1] != -1) {
//            map[x1][y1] = 0;
            flag[x1][y1] = -1;
            count += countPaths(flag, map, x1 - 1, y1, x2, y2, m, n);
        }

        if (y1 - 1 >= 0 && map[x1][y1 - 1] > map[x1][y1] && flag[x1][y1 - 1] != -1) {
//            map[x1][y1] = 0;
            flag[x1][y1] = -1;
            count += countPaths(flag,map, x1, y1 - 1, x2, y2, m, n);
        }

        if (x1 + 1 < m && map[x1 + 1][y1] > map[x1][y1] && flag[x1 + 1][y1] != -1) {
//            map[x1][y1] = 0;
            flag[x1][y1] = -1;
            count += countPaths(flag, map, x1 + 1, y1, x2, y2, m, n);
        }

        if (y1 + 1 < n && map[x1][y1 + 1] > map[x1][y1] && flag[x1][y1 + 1] != -1) {
//            map[x1][y1] = 0;
            flag[x1][y1] = -1;
            count += countPaths(flag, map, x1, y1 + 1, x2, y2, m, n);
        }

        return count;
    }

}
