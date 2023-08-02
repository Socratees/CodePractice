package leetcode2.p124;

public class Solution {
    int maxSum = Integer.MIN_VALUE;

    /**
     * 定义dfs函数，返回值为 以节点为根的路径最大值
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if (left > 0) {
            sum += left;
        }
        if (right > 0) {
            sum += right;
        }
        maxSum = Math.max(maxSum, sum);
        return Math.max(Math.max(left, right), 0) + root.val;
    }
}
