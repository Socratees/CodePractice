package leetcode.leetcode437;

public class Solution {
    public int paths = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        preorder(root, sum);
//        countPath(root, sum);
//        countPath(root.left, sum);
//        countPath(root.right, sum);
        return paths;
    }

    public void preorder(TreeNode root, int sum) {
        if (root != null) {
            countPath(root, sum);
            preorder(root.left, sum);
            preorder(root.right, sum);
        }
    }

    public void countPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            paths++;
        }
        countPath(root.left, sum - root.val);
        countPath(root.right, sum - root.val);


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(11);
//        TreeNode node7 = new TreeNode(3);
//        TreeNode node8 = new TreeNode(-2);
//        TreeNode node9 = new TreeNode(1);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        node5.right = node9;
        solution.pathSum(node1, 5);
        System.out.println(solution.paths);
    }
}
