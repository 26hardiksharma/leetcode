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
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr!=null) {
            stack.push(curr);
            curr = curr.next;
        }

        while(!stack.isEmpty()) {
            ListNode c= stack.pop();

            if(c.val !=  head.val) {
                return false;
            }

            head = head.next;
        }

        return true;
    }
}