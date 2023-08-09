package codingProblems.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListCycleTwo {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head;

        System.out.println(detectCycle(head).val);
    }

    /*
        BFS
        TC:
        SC:
     */
    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode startNode = null;
        Queue<ListNode> nodeToBeSeenQueue = new LinkedList<>();
        HashSet<ListNode> visited = new HashSet<>();

        nodeToBeSeenQueue.add(head);

        while (!nodeToBeSeenQueue.isEmpty()) {

            ListNode current = nodeToBeSeenQueue.poll();
            if (visited.contains(current)) {
                startNode = current;
                break;
            }
            visited.add(current);

            if (current.next != null) {
                nodeToBeSeenQueue.add(head.next);
            }
        }

        if (startNode == head) {
            return head;
        }

        return startNode;
    }

    /**
     * Fast and Slow Pointer - Floyd's Cycle Finding
     * TC: O(n)
     */
//    public static ListNode detectCycle(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return null;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//        boolean isCycle = false;
//
//        while (fast != null && fast.next != null) {
//
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if (slow == fast) {
//                isCycle = true;
//                break;
//            }
//        }
//
//        if (!isCycle) {
//            return null;
//        }
//
//        slow = head;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//
//        return slow;
//    }

    private static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
