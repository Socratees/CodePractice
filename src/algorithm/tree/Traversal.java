package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root) {
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

    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right == null || curr.right == pre){
                curr = stack.pop();
                res.add(curr.val);
                pre = curr;
                curr = null;
            }else{
                curr = curr.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(traversal.preorder(node1));
        System.out.println(traversal.postorder(node1));
    }
}
