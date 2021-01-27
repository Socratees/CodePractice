package others.jzoffer.problem35;

import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node currentNode = head.next;
        Node newCurrent = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, newHead);

        while (currentNode != null) {
            newCurrent.next = new Node(currentNode.val);
            map.put(currentNode, newCurrent.next);
            currentNode = currentNode.next;
            newCurrent = newCurrent.next;
        }

//        newCurrent = newHead;
        currentNode = head;
        while (currentNode != null) {
            if (currentNode.random != null) {
                newCurrent = map.get(currentNode);
                newCurrent.random = map.get(currentNode.random);
            }
            currentNode = currentNode.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.random = node1;
        node1.next = node2;
        node2.random = node1;
        Node root = solution.copyRandomList(node1);
    }
}
