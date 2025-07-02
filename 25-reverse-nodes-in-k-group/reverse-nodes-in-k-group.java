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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode Next;
        while(curr!=null){
            Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return head;
        ListNode curr=head;
        ListNode kth=head;
        for(int i=1;i<k;i++){
            kth=kth.next;
            if(kth==null){
                return head;
            }
        }
        ListNode Next=kth.next;
        kth.next=null;
        ListNode newHead=reverse(curr);
        curr.next=reverseKGroup(Next,k);
        return newHead;
    }
}