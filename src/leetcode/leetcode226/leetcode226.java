package leetcode.leetcode226;

public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = new TreeNode(0);
        if(root != null){
            node.val = root.val;
            node.left = invertTree(root.right);
            node.right = invertTree(root.left);
            return node;
        } else{
            return null;
        }
    }
}
