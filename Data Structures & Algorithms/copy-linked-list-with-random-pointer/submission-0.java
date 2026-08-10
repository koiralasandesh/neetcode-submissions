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

        HashMap<Node,Node> map = new HashMap<>();
        Node oldTrav = head;
        Node copy = new Node(0);
        Node newTrav = copy;

        while(oldTrav!=null){
            Node temp= new Node(oldTrav.val);
            newTrav.next=temp;
            map.put(oldTrav,newTrav.next);
            newTrav=newTrav.next;
            oldTrav=oldTrav.next;
        }

        oldTrav=head;
        newTrav=copy.next;

        while(oldTrav!=null){
            newTrav.random=map.get(oldTrav.random);
            oldTrav=oldTrav.next;
            newTrav=newTrav.next;
        }

        return copy.next;

        
    }
}
