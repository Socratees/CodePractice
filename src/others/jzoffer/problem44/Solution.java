package others.jzoffer.problem44;

public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        n -= 10;
        int digitCount = 2;
        long nums = digitCount * (long) Math.pow(10, digitCount - 1) * 9;
        while (n >= nums) {
            n -= nums;
            digitCount++;
            nums = digitCount * (long) Math.pow(10, digitCount - 1) * 9;
        }
        long a = n / digitCount;
        long b = n % digitCount;
        long lastNumber = 0;

        lastNumber = (long) Math.pow(10, digitCount - 1) + a;
        String s = String.valueOf(lastNumber);
        return (int) s.charAt((int) b) - (int) '0';

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(1000000000));
    }
}
