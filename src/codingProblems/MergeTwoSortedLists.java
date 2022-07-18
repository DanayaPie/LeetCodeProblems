package codingProblems;


public class MergeTwoSortedLists {

    // TODO: create a custom LinkedList and ListNode
    /*-
     *** Used 'ListNode' Class!!!
     */
//    public static void main(String[] args) {
//        System.out.println("asdf");
//        ListNode list1 = new ListNode();
//        while (list1.next == null) {
//            list1.next = new ListNode(1);
//            list1.next = new ListNode(2);
//            list1.next = new ListNode(4);
//        }
//
//        System.out.println(list1);
//
//        ListNode list2 = new ListNode();
//        list2.next = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next = new ListNode(4);
//
//        System.out.println(mergeTwoLists(list1, list2));
//    }
//
//
////     // iterative - fast
////     public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
////         ListNode resHead = new ListNode();
////         ListNode curr = resHead;
//
////         while (list1 != null && list2 != null) {
////             if (list1.val <  list2.val) {
////                 curr.next = list1;
////                 list1 = list1.next;
////             } else {
////                 curr.next = list2;
////                 list2 = list2.next;
////             }
////             curr = curr.next;
////         }
//
////         if (list1 == null) {
////             curr.next = list2;
////         }
////         if (list2 == null) {
////             curr.next = list1;
////         }
//
////         return resHead.next;
////     }
//
//    // recursive - fast
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        if (list1.val <= list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list2.next, list1);
//        }
//        return list2;
//    }
//}
}
