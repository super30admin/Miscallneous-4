// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1){
            return head;
        }
        ListNode dummy = new ListNode(-1,head);

        //start of k group
        ListNode start = dummy;
        // end of k group
        ListNode end = head;
        ListNode prev = dummy;

        while(end != null){

            int count = 1;
            // find the end of the k group
            while(end != null && count <= k){
                end = end.next;
                count++;
            }

            if(count <= k) return dummy.next;

            ListNode cur = start.next;
            ListNode revStart = start.next;

            // reverse the k group
            while(count != 1){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count--;
            }

            // connect the start and end of the reversed group appropriately
            start.next = prev;
            revStart.next = end;

            // reset the start, end and prev
            start = revStart;
            end = revStart.next;
            prev = revStart;
        }
        return dummy.next;

    }
}