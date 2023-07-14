package codingProblems.Java;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(middleNode(head).data);
    }

    /**
     * Fast and Slow Pointers
     * TC: O(n)
     */
    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next; // O(n)
            fast = fast.next.next; // O(n/2)
        }

        return slow;
    }

    public static class ListNode {

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
