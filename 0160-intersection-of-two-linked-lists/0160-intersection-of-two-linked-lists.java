/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while(ptrA != null && ptrB != null) {
            if(ptrA == ptrB) {
                return ptrA;
            }

            if(ptrA.next == null && ptrB.next == null) return null;
            
            ptrA = (ptrA.next == null) ? headA : ptrA.next;
            ptrB = (ptrB.next == null) ? headB : ptrB.next;
        }

        return null;


    }
}