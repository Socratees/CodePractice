package leetcode.leetcode944;

public class leetcode944 {
    public int minDeletionSize(String[] A) {
        int counter = 0;
        for (int i = 0; i < A[0].length(); i++) {
            int index = 0;
            while (index < A.length - 1) {
                if (A[index].charAt(i) > A[index + 1].charAt(i)) {
                    counter++;
                    break;
                }
                index++;
            }
        }
        return counter;
    }
}
