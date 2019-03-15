package leetcode.leetcode476;

public class leetcode476 {
    public static int findComplement(int num) {
        int result = 0;
        int counter = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                result += (int) Math.pow(2, counter);
            }
            counter++;
            num = num >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
