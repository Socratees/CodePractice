package others.oj_njuse.problem124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        scanner.nextLine();
        String line = "";
        for (int c = 0; c < caseNum; c++) {
            line = scanner.nextLine();
            String[] str = line.split(",");
            double[][] points = new double[str.length][2];
            for (int i = 0; i < str.length; i++) {
                points[i] = Arrays.stream(str[i].split(" ")).mapToDouble(Double::parseDouble).toArray();
            }
            double[][] temp = new double[points.length][2];
            //对points的升序排序
            for (int i = 0; i < points.length; i++) {
                int index = i;
                for (int j = i; j < points.length; j++) {
                    if (points[index][0] > points[j][0] || (points[index][0] == points[j][0] && points[index][1] > points[j][1])) {
                        index = j;
                    }
                }
                if (index != i) {
                    double[] tmp = points[index];
                    points[index] = points[i];
                    points[i] = tmp;
                }

            }

            double minDistance = getMinDistance(points, 0, temp.length - 1);
            List<Double> list = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (Math.abs(calculateDistance(points[i], points[j]) - minDistance) < 0.000001) {
                        list.add(points[i][0]);
                        list.add(points[i][1]);
                        list.add(points[j][0]);
                        list.add(points[j][1]);
                    }
                }
            }

            for (int i = 0; i < list.size(); i += 4) {
                if (i != 0) {
                    System.out.print(",");
                }
                String[] double2String = new String[4];

                for (int j = 0; j < 4; j++) {
                    double2String[j] = String.valueOf(list.get(i + j));
                    if (double2String[j].endsWith(".0")) {
                        double2String[j] = double2String[j].substring(0, double2String.length - 3);
                    }
                }
                System.out.print(double2String[0] + " " + double2String[1] + "," + double2String[2] + " " + double2String[3]);
            }


            System.out.println();

        }
    }


    public static double getMinDistance(double[][] points, int left, int right) {
        if (right - left == 1) {
            return calculateDistance(points[left], points[right]);
        }
        if (right <= left) {
            return Double.MAX_VALUE;
        }

        int mid = left + (right - left) / 2;
        double d1 = getMinDistance(points, left, mid);
        double d2 = getMinDistance(points, mid + 1, right);
        double d = Math.min(d1, d2);
        double midX = (points[mid][0] + points[mid + 1][0]) / 2;
        for (int i = 0; i <= mid; i++) {
            if (midX - points[i][0] <= d) {
                for (int j = mid + 1; j <= right; j++) {
                    if (points[j][0] - midX <= d && Math.abs(points[j][1] - points[i][1]) <= d) {
                        double thisDistance = calculateDistance(points[i], points[j]);
                        d = Math.min(d, thisDistance);
                    }
                }
            }
        }

        return d;
    }

    public static double calculateDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
}
