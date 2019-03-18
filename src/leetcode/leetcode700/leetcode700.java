package leetcode.leetcode700;

public class leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = null;

        if (root != null) {
            if(root.val == val){
                return root;
            }else{
                if(root.left != null){
                    node = searchBST(root.left,val);
                }
                if(root.right != null && node == null){
                    node = searchBST(root.right,val);
                }
                return node;
            }
        }


        return node;
    }
}
