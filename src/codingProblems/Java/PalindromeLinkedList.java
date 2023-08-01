package codingProblems.Java;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        codingProblems.Java.PalindromeLinkedList.ListNode head = new codingProblems.Java.PalindromeLinkedList.ListNode(0);
        head.next = new codingProblems.Java.PalindromeLinkedList.ListNode(3);
        head.next.next = new codingProblems.Java.PalindromeLinkedList.ListNode(9);
        head.next.next.next = new codingProblems.Java.PalindromeLinkedList.ListNode(4);
        head.next.next.next.next = new codingProblems.Java.PalindromeLinkedList.ListNode(0);

        System.out.println(isPalindrome(head));
    }

    /**
     * Fast and Slow Pointers
     * TC: O(n)
     */
    public static boolean isPalindrome(codingProblems.Java.PalindromeLinkedList.ListNode head) {

        codingProblems.Java.PalindromeLinkedList.ListNode slow = head;
        codingProblems.Java.PalindromeLinkedList.ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        codingProblems.Java.PalindromeLinkedList.ListNode rightEnd = reversLinkedList(slow);
        codingProblems.Java.PalindromeLinkedList.ListNode leftEnd = head;

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

    private static codingProblems.Java.PalindromeLinkedList.ListNode reversLinkedList(codingProblems.Java.PalindromeLinkedList.ListNode head) {

        codingProblems.Java.PalindromeLinkedList.ListNode prev = null;

        while (head != null) {
            codingProblems.Java.PalindromeLinkedList.ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private static class ListNode {

        int data;
        codingProblems.Java.PalindromeLinkedList.ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}


