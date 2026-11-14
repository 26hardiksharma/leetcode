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
    public int pairSum(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();

        ListNode curr = head;

        while(curr!= null) {
            l.add(curr.val);
            curr = curr.next;
        }
        int max = Integer.MIN_VALUE;
        int size = l.size();
        for(int i = 0;i<size;i++) {
            max = Math.max(max,l.get(i) + l.get(size-i-1));
        }

        return max;
    }
}