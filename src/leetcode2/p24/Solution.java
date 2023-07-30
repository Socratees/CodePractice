package leetcode2.p24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0), cur = head, next = head.next;
        ListNode dummyHead = pre;
        pre.next = head;
        while (cur != null && cur.next != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = next;
            cur = next.next;
        }

        return dummyHead.next;
    }
}
