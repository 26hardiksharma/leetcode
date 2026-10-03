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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;    
            current.next = prev;    
            prev = current;         
            current = next;         
        }
        
        return prev; 
    }
    public int getDecimalValue(ListNode head) {
        int binary = 0;
        head = reverse(head);
        int digit = 0;
        while(head !=null) {
            binary += head.val*Math.pow(2,digit);
            digit++;
            head = head.next;
        }

        return binary;

    }
}