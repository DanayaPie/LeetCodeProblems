package codingProblems.Java;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        ListNode mergedHead = mergeKLists(lists);

        while (mergedHead != null) {
            System.out.print(mergedHead.val + " -> ");

            mergedHead = mergedHead.next;
        }
    }

    /**
     * Heap - Priority Queue storing ListNode
     * TC: O(n log k), k is number of lists
     * SC: O(k), only can story k element at a time
     //     */
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode mergedHead = new ListNode();
        ListNode current = mergedHead;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add head of each list into minHeap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {

            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return mergedHead.next;
    }

    /**
     * Heap - Priority Queue storing val
     * TC: O(n log k), k is number of list
     * SC: O(n), O(n) from PQ (pop later) and O(n) from result list (new ListNode)
     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//
//        ListNode mergedHead = new ListNode();
//        ListNode current = mergedHead;
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        // add all ele into minHeap - ordered from min to max by default
//        for (int i = 0; i < lists.length; i++) {
//
//            ListNode node = lists[i];
//
//            while (node != null) {
//                minHeap.offer(node.val);
//                node = node.next;
//            }
//        }
//
//        while (!minHeap.isEmpty()) {
//            current.next = new ListNode(minHeap.poll()); // create new node to store val
//            current = current.next;
//        }
//
//        return mergedHead;
//    }


    /**
     * Brute Force
     * TC: O(kn), k is the number of linked lists
     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        ListNode mergedList = lists[0];
//
//        for (int i = 1; i < lists.length; i++) {
//            mergedList = mergeTwoListNode(mergedList, lists[i]);
//        }
//
//        return mergedList;
//    }
//
//    private static ListNode mergeTwoListNode(ListNode list1, ListNode list2) {
//
//        ListNode mergedHead = new ListNode();
//        ListNode current = mergedHead;
//
//        while (list1 != null && list2 != null) {
//
//            if (list1.val < list2.val) {
//                current.next = list1;
//                list1 = list1.next;
//            } else {
//                current.next = list2;
//                list2 = list2.next;
//            }
//
//            current = current.next;
//        }
//
//        if (list1 != null) {
//            current.next = list1;
//        } else {
//            current.next = list2;
//        }
//
//        return mergedHead.next;
//    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


