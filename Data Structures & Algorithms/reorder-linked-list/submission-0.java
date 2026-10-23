/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // slow will be at mid
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next); // slow.next is just other half, and we reverse it
        slow.next = null; // cutt off connection between 2 halves
        // at this point secondHalf is one part and head is one part

        ListNode first = head; // This is now first half

        while (secondHalf != null) {
            ListNode secondNext = secondHalf.next;
            ListNode firstNext = first.next;

            first.next = secondHalf;
            secondHalf.next = firstNext;

            first = firstNext;
            secondHalf = secondNext;
            
        }
        
    }

    public ListNode reverse(ListNode head) {
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
