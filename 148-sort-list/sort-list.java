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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=findMid(head);
        ListNode left=head, right=mid.next;
        mid.next=null;
        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
    public ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode dummy=new ListNode(0);
        ListNode ptr=dummy;
        while(leftHead!=null && rightHead!=null){
            if(leftHead.val<rightHead.val){
                ptr.next=leftHead;
                leftHead=leftHead.next;
            }
            else{
                ptr.next=rightHead;
                rightHead=rightHead.next;
            }
            ptr=ptr.next;
        }
        while(leftHead!=null){
            ptr.next=leftHead;
            leftHead=leftHead.next;
            ptr=ptr.next;
        }
        while(rightHead!=null){
            ptr.next=rightHead;
            rightHead=rightHead.next;
            ptr=ptr.next;
        }
        ptr.next=null;
        return dummy.next;
    }
    public ListNode findMid(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}