package leetcode2.p94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>();
//        List<Integer> left = inorderTraversal(root.left);
//        res.addAll(left);
//
//        res.add(root.val);
//
//        List<Integer> right = inorderTraversal(root.right);
//        res.addAll(right);
//
//        return res;
//    }

    /**
     * 非递归解法，用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
