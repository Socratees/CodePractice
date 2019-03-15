package leetcode.leetcode942;

/**
 * @Description:
 * @Author: liuzhibiao
 * @Date: 2019/3/14
 */
public class leetcode942 {
    //遇到的第一个I就置0，遇到的第一个D置N
    public int[] diStringMatch(String S) {
        int N = S.length(), min = 0, max = N;
        int[] r = new int[N + 1];
        for (int i = 0; i < N; i++) {
            r[i] = S.charAt(i) == 'I' ? min++ : max--;
        }
        r[N] = min;
        return r;
    }
}
