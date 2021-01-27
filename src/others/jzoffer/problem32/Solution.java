package others.jzoffer.problem32;

import java.util.*;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode node = null;
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        while (!queue.isEmpty()) {
            nodes = new ArrayList<>();
            nums = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.peek());
                nums.add(queue.peek().val);
                queue.poll();
            }
            if (nums.size() > 0) {
                result.add(nums);
            }
            for (TreeNode treeNode : nodes) {
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

        }
        return result;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int layer = 1;
        TreeNode node = null;
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()){
                if(layer%2==1){

                }
            }

        }

        return result;
    }
}
