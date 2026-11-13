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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr;
            int count = 0;

            while(temp != null && temp.val == curr.val) {
                temp = temp.next;
                count++;
            }
            if(count == 1) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            if(prev == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
            curr = temp;
        }
        return head;
    }
}