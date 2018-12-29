package leetcode.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(list);
        }
        return result;
    }
}
