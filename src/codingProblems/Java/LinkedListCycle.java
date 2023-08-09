package codingProblems.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }

    /**
     * Fast and Slow Pointers or Floyd's Cycle Finding
     * TC: O(n)
     */
    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next; // O(n)
            fast = fast.next.next; // O(n/2)
        }

        return false;
    }

    /**
     * BFS with HashSet
     * TC: O(n)
     * SC: O(n)
     */
//    public static boolean hasCycle(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        Queue<ListNode> toBeSeenQueue = new LinkedList<>();
//        Set<ListNode> visited = new HashSet<>();
//        toBeSeenQueue.add(head);
//
//        while (!toBeSeenQueue.isEmpty()) {
//            ListNode current = toBeSeenQueue.poll();
//
//            if (visited.contains(current)) {
//                return true;
//            }
//            visited.add(current);
//
//            if (current.next != null) {
//                toBeSeenQueue.add(current.next);
//            }
//
//        }
//
//        return false;
//    }

    private static class ListNode {

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
