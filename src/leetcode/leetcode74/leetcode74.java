package leetcode.leetcode74;

public class leetcode74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int head = 0;
        int tail = matrix.length - 1;
        int mid = 0;
        while (head < tail) {

            mid = (head + tail) / 2;
//            System.out.println(head);
            if (target < matrix[mid][0]) {
                tail = mid - 1;
            } else if (target > matrix[mid][0]) {
                head = mid + 1;
            } else {
                return true;
            }
        }

        System.out.println("head: "+String.valueOf(head));
        if (target < matrix[head][0]) {
            if (head == 0)
                return false;
            else {
                for (int i = 0; i < matrix[0].length; i++) {
                    if (matrix[head - 1][i] == target)
                        return true;
                }
                return false;
            }
        } else {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[head][i] == target)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{3}};
        System.out.println(searchMatrix(matrix,0));
    }
}
