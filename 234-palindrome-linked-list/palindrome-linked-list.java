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
    public boolean isPalindrome(ListNode head) {
        if(head == null && head.next == null) return true;
        ListNode slow = head , fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);
        ListNode first = head , second = newHead;
        while(second!= null){
            if(first.val != second.val){
                reverseList(slow.next);
                return false;
            }
            first = first.next;
            second = second.next;
           
        }
         reverseList(slow.next);
        return true;
    }
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}