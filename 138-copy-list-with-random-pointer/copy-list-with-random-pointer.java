/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(-1);
        Node curr=dummy;
        Node temp=head;
        
        while(temp!=null){
            Node new1=new Node(temp.val);
            new1.next=temp.next;
            temp.next=new1;
            temp=temp.next.next;
        }
        
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null)
                copy.random=temp.random.next;
            else{
                copy.random=null;
            }
            temp=temp.next.next;
        }
        
        temp=head;
        while(temp!=null){
            curr.next=temp.next;
            temp.next=temp.next.next;
            curr=curr.next;
            temp=temp.next;
        }
        curr.next=null;
        return dummy.next;
    }
}