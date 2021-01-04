package others.oj_njuse.problem108;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int base = scanner.nextInt();
                int exponent = scanner.nextInt();
                int modular = scanner.nextInt();
                System.out.println(myPow(base, exponent, modular));
            }
        }
    }

    public static int myPow(int base, int exponent, int modular) {
        if (exponent == 1) {
            return base % modular;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent % 2 == 1) {
            return (myPow(base, (exponent - 1) / 2, modular) * myPow(base, (exponent - 1) / 2, modular) * (base % modular)) % modular;
        } else {
            return (myPow(base, exponent / 2, modular) * myPow(base, exponent / 2, modular)) % modular;
        }
    }
}
