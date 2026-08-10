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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode resultTraverse = result;
        ListNode temp1=list1;
        ListNode temp2=list2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                resultTraverse.next=temp1;
                temp1=temp1.next;
                resultTraverse=resultTraverse.next;
            }
            else{
                resultTraverse.next=temp2;
                temp2=temp2.next;
                resultTraverse=resultTraverse.next;
            }
        }

        if (temp1==null){
            resultTraverse.next=temp2;
        }
        else{
            resultTraverse.next=temp1;
        }
        return result.next;
        
    }
}