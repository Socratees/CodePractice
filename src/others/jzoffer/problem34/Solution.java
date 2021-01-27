package others.jzoffer.problem34;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        findPath(root, path, sum, 0);
        return result;
    }

    public void findPath(TreeNode root, ArrayDeque<Integer> path, int sum, int currentSum) {
        currentSum += root.val;
        path.addLast(root.val);
        //是叶节点，则加入result
        if (currentSum == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        //非叶节点，则遍历其子节点
        if (root.left != null) {
            findPath(root.left, path, sum, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, path, sum, currentSum);
        }
        path.removeLast();
    }

}
