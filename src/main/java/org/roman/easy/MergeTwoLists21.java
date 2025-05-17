package org.roman.easy;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 *
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * */

public class MergeTwoLists21 {

    public static void main(String[] args) {

        MergeTwoLists21 obj = new MergeTwoLists21();
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1,3,4});
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode(0);
        System.out.println(obj.mergeTwoLists(l3, l4));
//        System.out.println(obj.mergeTwoLists(l1, l2).toString());

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor con valor y siguiente

        public ListNode(int[] ints) {
            int loop = 0;
            while (loop < ints.length) {
                this.val = ints[loop];
                loop++;
            }
        }
    }
}
