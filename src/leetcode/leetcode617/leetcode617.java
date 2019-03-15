package leetcode.leetcode617;

public class leetcode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTree = new TreeNode(0);
        if (t1 != null && t2 != null) {
            int value = 0;
            value = t1.val + t2.val;
            newTree.val = value;
            newTree.left = mergeTrees(t1.left, t2.left);
            newTree.right = mergeTrees(t1.right, t2.right);
        } else if (t1 != null) {
            newTree.val = t1.val;
            newTree.left = mergeTrees(t1.left, null);
            newTree.right = mergeTrees(t1.right, null);
        } else if (t2 != null) {
            newTree.val = t2.val;
            newTree.left = mergeTrees(null, t2.left);
            newTree.right = mergeTrees(null, t2.right);
        }else{
            return null;
        }

        return newTree;
    }
}
