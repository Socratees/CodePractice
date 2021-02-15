package others.jzoffer.problem52;

import java.util.Stack;

public class Solution {

    // 两个链表长度分别为L1+C、L2+C， C为公共部分的长度
    // 第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，回到第一个人起点走L1步。
    // 当两个人走的步数都为L1+L2+C时两个指针相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = (h1 == null) ? headB : h1.next;
            h2 = (h2 == null) ? headA : h2.next;
        }
        return h1;
    }

}
