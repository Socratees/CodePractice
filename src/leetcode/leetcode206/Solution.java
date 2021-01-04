package leetcode.leetcode206;

public class Solution {
    //迭代方法，定义三个指针
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode postNode = head.next;
        while (postNode != null) {
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = postNode;
            postNode = postNode.next;
        }
        currentNode.next = preNode;
        return currentNode;
    }

    //递归方法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
