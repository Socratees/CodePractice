package leetcode.leetcode171;

public class leetcode171 {
    public int titleToNumber(String s) {
        int sum = 0;
        int index = s.length() - 1;
        while (index >= 0){
            char c = s.charAt(index);
            int temp = (int) (c - 64);
            sum += temp * Math.pow(26, s.length() - 1 - index);

            index--;
        }
        return sum;
    }
}
