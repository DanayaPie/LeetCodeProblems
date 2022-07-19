package codingProblems;

public class ListNode {

    // TODO: finish the ListNode class
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

    public String toString() {
        return this.val + ", " + this.next.val;
    }
}
