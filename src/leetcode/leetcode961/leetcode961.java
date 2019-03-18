package leetcode.leetcode961;

public class leetcode961 {
    public int repeatedNTimes(int[] A) {
        int N = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            int counter = 0;
            for(int j = i;j < A.length; j++){
                if(A[i] == A[j]){
                    counter++;
                }
            }
            if(counter == N){
                return A[i];
            }
        }
        return 0;
    }
}
