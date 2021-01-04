package others.jzoffer.problem27;

public class Solution {
    //左子树变为右子树的镜像，右子树变为左子树的镜像
    public TreeNode getMirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode newLeft = getMirrorTree(root.right);
        TreeNode newRight = getMirrorTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
