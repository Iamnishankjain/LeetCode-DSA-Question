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
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode t1=head1;
        ListNode t2=head2;
        while(t1!=null && t2!=null){
            if(t1==t2) return t1;
            if(t1.next==null){
                t1=head2;
                t2=t2.next;
                continue;
            }
            if(t2.next==null){
                t2=head1;
                t1=t1.next;
                continue;
            }
            t2=t2.next;
            t1=t1.next;
        }
        return null;
    }
}