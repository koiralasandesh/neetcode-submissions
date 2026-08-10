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
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode mid = slow.next;
        slow.next=null;

        ListNode prev = null;
        ListNode curr = mid;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        mid =prev;
        curr=head;

        while(curr!= null && mid!=null){
            ListNode currTemp = curr.next;
            ListNode midTemp = mid.next;
            curr.next=mid;
            curr.next.next=currTemp;
            curr=currTemp;
            mid=midTemp;

        } 

    }
}
