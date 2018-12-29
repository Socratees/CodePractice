package leetcode.leetcode101;

public class leetcode101 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root,root);
    }
}
