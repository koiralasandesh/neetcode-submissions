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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l2==null) return l1;
        if (l1==null) return l2;
        
        int carry=0;
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(l1!=null || l2!=null || carry!=0){
            int sum = ((l1==null)? 0 : l1.val)+((l2==null)? 0 : l2.val)+carry;

            int rem = sum%10;
            carry = sum/10;
            curr.next=new ListNode(rem);

            l1= (l1!=null)? l1.next : l1;
            l2= (l2!=null)? l2.next : l2;
            curr=curr.next;
        }

        return result.next;
        
    }
}
