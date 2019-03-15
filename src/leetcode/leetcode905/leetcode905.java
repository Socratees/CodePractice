package leetcode.leetcode905;

public class leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 == 1) {
                while (right >=0 && A[right] % 2 == 1) {
                    right--;
                }
                if (left < right) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                }
            }
            left++;
        }
        return A;
    }
}
