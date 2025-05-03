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
        HashMap<Node,Node> map=new HashMap<>();
        Node dummy=new Node(-1);
        Node curr=dummy;
        Node temp=head;
        while(temp!=null){
            curr.next=new Node(temp.val);
            curr=curr.next;
            temp=temp.next;
        }
        curr=dummy.next;
        temp=head;
        while(curr!=null){
            map.put(temp,curr);
            temp=temp.next;
            curr=curr.next;
        }
        temp=head;
        curr=dummy.next;
        while(temp!=null){
            Node value=map.get(temp.random);
            curr.random=value;
            curr=curr.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}