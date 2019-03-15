package leetcode.leetcode657;

public class leetcode657 {
    public boolean judgeCircle(String moves) {
        int m = 0, n = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    m++;
                    break;
                case 'D':
                    m--;
                    break;
                case 'L':
                    n++;
                    break;
                case 'R':
                    n--;
                    break;
                default:
                    break;
            }
        }


        return (m == 0 && n == 0);
    }
}
