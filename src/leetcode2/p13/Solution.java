package leetcode2.p13;

public class Solution {
    /**
     * 从右向左遍历，遇到左<右的情况则符号为负号，否则为正号
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1) {
                sum += transfer(s.charAt(i));
                continue;
            }
            if (transfer(s.charAt(i)) < transfer(s.charAt(i + 1))) {
                sum -= transfer(s.charAt(i));
            } else {
                sum += transfer(s.charAt(i));
            }
        }
        return sum;
    }

    public int transfer(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
