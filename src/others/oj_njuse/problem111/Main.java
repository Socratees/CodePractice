package others.oj_njuse.problem111;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int k = 0; k < n; k++) {
            int length = scanner.nextInt();
            int[][] marks = new int[length][3];
            for (int i = 0; i < length; i++) {
                marks[i][0] = scanner.nextInt();
                marks[i][1] = scanner.nextInt();
                marks[i][2] = scanner.nextInt();
            }
            for (int i = 0; i < length; i++) {
                int index = i;
                for (int j = i + 1; j < length; j++) {
                    if (compareMarks(marks[index], marks[j]) == -1) {
                        index = j;
                    }
                }
                if (index != i) {
                    int[] tmp = marks[i];
                    marks[i] = marks[index];
                    marks[index] = tmp;
                }
            }

            for (int i = 0; i < length; i++) {
                System.out.println(marks[i][0] + " " + marks[i][1] + " " + marks[i][2]);
            }

        }
    }

    //a<b, 返回值为1;a=b, 返回0;a>b, 返回-1
    public static int compareMarks(int[] a, int[] b) {
        boolean state1 = (a[0] < b[0]);
        boolean state2 = (a[0] == b[0] && a[1] > b[1]);
        boolean state3 = (a[0] == b[0] && a[1] == b[1] && a[2] < b[2]);
        boolean state4 = (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]);
        if (state1 || state2 || state3) {
            return 1;
        } else if (state4) {
            return 0;
        }
        return -1;
    }
}
