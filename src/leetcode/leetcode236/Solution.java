package leetcode.leetcode236;

import java.util.Stack;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        if (root == null) {
            return null;
        }
        if ((dfs(root.left, p, q) && dfs(root.right, p, q)) || ((root.val == p.val || root.val == q.val) && (dfs(root.left, p, q) || dfs(root.right, p, q)))){

        }
            return result;
    }


    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == p.val || node.val == q.val) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;

    }
}
