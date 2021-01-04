package others.oj_njuse.problem112;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int length = scanner.nextInt();
                int[] arrival = new int[length];
                int[] left = new int[length];
                int minTime = Integer.MAX_VALUE;
                int maxTime = Integer.MIN_VALUE;
                for (int i = 0; i < length * 2; i++) {
                    if (i < length) {
                        arrival[i] = scanner.nextInt();
                        minTime = Math.min(minTime, arrival[i]);
                    } else {
                        left[i - length] = scanner.nextInt();
                        maxTime = Math.max(maxTime, left[i - length]);
                    }
                }

//                int[] timeArr = new int[maxTime - minTime + 1];
                int t = minTime;
                int maxNum = 0;
                for (int i = minTime; i <= maxTime; i++) {
                    int tmp = getNumByTime(arrival, left, i);
                    if (tmp > maxNum) {
                        maxNum = tmp;
                        t = i;
                    }
                }

                System.out.println(maxNum+" "+t);

            }
        }
    }

    public static int getNumByTime(int[] arrival, int[] left, int time) {
        int count = 0;
        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= time) {
                count++;
            }
            if (left[i] < time) {
                count--;
            }
        }

        return count;
    }
}
