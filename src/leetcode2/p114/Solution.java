package leetcode2.p114;

public class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
