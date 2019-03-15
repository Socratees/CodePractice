package leetcode.leetcode985;

public class leetcode985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            A[queries[i][1]] += queries[i][0];
            sum = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    sum += A[j];
                }
            }
            result[i] = sum;
        }
        return result;
    }
}
