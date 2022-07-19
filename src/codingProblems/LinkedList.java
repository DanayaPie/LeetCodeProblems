package codingProblems;

public class LinkedList {

    // TODO: finish the LinkedList class
    ListNode head;

    public void append(int val) {
        ListNode current = head;
        if (head == null) {
            head = new ListNode(val);
            return;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    public void prepend(int data) {
        ListNode newHead = new ListNode(data);
        newHead.next = head;
        head = newHead;
    }
}
