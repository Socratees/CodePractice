package leetcode.leetcode965;

public class leetcode965 {
    public boolean isUnivalTree(TreeNode root) {
        boolean result = true;
        if (root != null) {
            if (root.left != null) {
                result = result && (root.val == root.left.val);
            }
            if(root.right != null){
                result = result && (root.val == root.right.val);
            }
            result = result && isUnivalTree(root.left) && isUnivalTree(root.right);
        }
        return result;
    }
}
