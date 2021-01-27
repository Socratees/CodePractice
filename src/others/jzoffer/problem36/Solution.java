package others.jzoffer.problem36;

public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        Node current = null;
        Node leftListHead = null;
        Node rightListTail = null;
        if (root.left != null) {
            leftListHead = treeToDoublyList(root.left);
            current = leftListHead;
            //找到左侧链表的最大值,即表尾
            while (current.right.val != leftListHead.val) {
                current = current.right;
            }

            current.right = root;
            root.left = current;
        }
        if (root.right != null) {
            Node rightListHead = treeToDoublyList(root.right);
            current = rightListHead;

            //找右侧链表表尾
            while (current.right.val != rightListHead.val) {
                current = current.right;
            }

            rightListTail = current;
            root.right = rightListHead;
            rightListHead.left = root;
        }
        //左表头和右表尾相连
        if (leftListHead != null && rightListTail != null) {
            leftListHead.left = rightListTail;
            rightListTail.right = leftListHead;
        }else if(leftListHead==null){
            root.left = rightListTail;
            rightListTail.right = root;
        }else if(rightListTail==null){
            root.right = leftListHead;
            leftListHead.left = root;
        }

        return (leftListHead != null) ? leftListHead : root;
    }

}
