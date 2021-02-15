package others.jzoffer.problem55;

public class Solution2 {
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        boolean left = isBalanced(root.left);
//        boolean right = isBalanced(root.right);
//        int leftLength = maxDepth(root.left);
//        int rightLength = maxDepth(root.right);
//        if(Math.abs(leftLength-rightLength)>1){
//            return false;
//        }
//        return left && right ;
//    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }


    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    //后序遍历+剪枝算法，很快啊！
    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
