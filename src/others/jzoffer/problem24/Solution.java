package others.jzoffer.problem24;

public class Solution {
    //迭代方法，使用三个指针翻转链表
    public ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode preNode = null;
        ListNode currentNode = root;
        ListNode postNode = currentNode.next;
        while (postNode != null) {
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = postNode;
            postNode = postNode.next;
        }
        currentNode.next = preNode;
        return currentNode;
    }

    //递归方法翻转链表
    public ListNode reverseList2(ListNode root){
        if(root == null || root.next==null){
            return root;
        }

        ListNode newRoot = reverseList2(root.next);
        root.next.next = root;
        root.next = null;
        return newRoot;
    }
}
