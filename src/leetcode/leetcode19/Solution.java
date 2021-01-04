package leetcode.leetcode19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode currentNode = head;
        ListNode postNode = head;
        for (int i = 0; i < n; i++) {
            postNode = postNode.next;
        }
        //如果是删除第一个节点
        if (postNode == null) {
            return head.next;
        }
        //让currentNode成为倒数第k+1个
        postNode = postNode.next;
        while (postNode != null) {
            postNode = postNode.next;
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;

        return head;
    }
}
