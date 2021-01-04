package leetcode.leetcode98;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = inOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        if (root == null) {
            return inOrderList;
        }
        inOrderList.addAll(inOrder(root.left));
        inOrderList.add(root.val);
        inOrderList.addAll(inOrder(root.right));
        return inOrderList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(solution.inOrder(node2));
        System.out.println(solution.isValidBST(node2));
    }
}
