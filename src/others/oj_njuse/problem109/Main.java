package others.oj_njuse.problem109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int pointNum = scanner.nextInt();
                //构成凸多边形至少需要三个点
                if (pointNum <= 2) {
                    System.out.println(-1);
                    continue;
                }
//                int[][] points = new int[pointNum][2];
//                //起始点
//                int startIndex = 0;
//                int minY = Integer.MAX_VALUE;
//                int minX = Integer.MAX_VALUE;
//                for (int i = 0; i < pointNum; i++) {
//                    points[i][0] = scanner.nextInt();
//                    points[i][1] = scanner.nextInt();
//                    if (points[i][1] < minY || (points[i][1] == minY && points[i][0] < minX)) {
//                        startIndex = i;
//                        minX = points[i][0];
//                        minY = points[i][1];
//                    }
//                }
//                //把起始点放到数组第一位
//                if (startIndex != 0) {
//                    int[] tmp = points[startIndex];
//                    points[startIndex] = points[0];
//                    points[0] = tmp;
//                }

                List<Point> remainPoints = new ArrayList<>();
                List<Point> selectPoints = new ArrayList<>();
                int startIndex = 0;
                int minY = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                for (int i = 0; i < pointNum; i++) {
                    Point p = new Point(0, 0);
                    p.x = scanner.nextInt();
                    p.y = scanner.nextInt();
                    remainPoints.add(p);
                    if (p.y < minY || (p.y == minY && p.x < minX)) {
                        startIndex = i;
                        minX = p.x;
                        minY = p.y;
                    }
                }
                selectPoints.add(remainPoints.get(startIndex));
                remainPoints.remove(startIndex);

                int[][] vectors = new int[pointNum - 1][2];
                double[] cosTheta = new double[pointNum - 1];
                for (int i = 0; i < remainPoints.size(); i++) {
                    vectors[i][0] = remainPoints.get(i).x - selectPoints.get(0).x;
                    vectors[i][1] = remainPoints.get(i).y - selectPoints.get(0).y;
                    //和向量(1,0)计算夹角余弦值
                    cosTheta[i] = vectors[i][0] / Math.sqrt(Math.pow(vectors[i][0], 2) + Math.pow(vectors[i][1], 2));
                }
                boolean isLine = true;
                for (int i = 1; i < cosTheta.length; i++) {
                    if (Math.abs(cosTheta[i] - cosTheta[0]) > 0.00001) {
                        isLine = false;
                    }
                }
                //所有点在一条直线上，无凸包
                if (isLine) {
                    System.out.println(-1);
                    return;
                }

                


            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
