package codingProblems.Java;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        System.out.println(isPalindrome(head));
    }

    /**
     * Fast and Slow Pointers
     * TC: O(n)
     */
    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode rightEnd = reversLinkedList(slow);
        ListNode leftEnd = head;

        while (rightEnd != null) {

            if (leftEnd.data != rightEnd.data) {
                return false;
            }

            leftEnd = leftEnd.next;
            rightEnd = rightEnd.next;
        }

        // reverse the second half back to original if required
//        slow.next = reversLinkedList(rightEnd);

        return true;
    }

    private static ListNode reversLinkedList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

class ListNode {

    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
