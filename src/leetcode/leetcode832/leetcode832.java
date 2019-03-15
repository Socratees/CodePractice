package leetcode.leetcode832;

public class leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int m = 0, n = A[i].length-1;
            while(m < n){
                int temp = A[i][m];
                A[i][m] = 1- A[i][n];
                A[i][n] = 1- temp;
                m++;
                n--;
            }
            if(m == n){
                A[i][m] = 1 - A[i][m];
            }

        }
        return A;
    }
}
